package swift.displayer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import swift.displayer.Dto.BankDTO;
import swift.displayer.Dto.MessageResponse;

import java.util.List;

@Controller
public class DisplayerController {


    @GetMapping("/")
    public String display() {
        return "home";
    }
    @GetMapping("/showBanks")
    public String banks() {
        return "showBanks";
    }
    @GetMapping("/showBanks/all")
    public String bank(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/v1/swift-codes/";
        ResponseEntity<List<BankDTO>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        List<BankDTO> banks = response.getBody();
        model.addAttribute("banks", banks);

        return "allBanks";
    }
    @GetMapping("/showBanks/swift-code")
    public String bankSwiftCode(@RequestParam String swiftCode, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/v1/swift-codes/" + swiftCode;
        ResponseEntity<BankDTO> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        BankDTO bank= response.getBody();
        model.addAttribute("bank", bank);
        return "showBanks";
    }
    @GetMapping("/addBank")
    public String addBank(Model model) {
        model.addAttribute("bankDTO", new BankDTO());
        return "addBank";
    }
    @PostMapping("/submitBank")
    public String submitBank(@ModelAttribute("bankDTO") BankDTO bank, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/v1/swift-codes/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String bankJson = objectMapper.writeValueAsString(bank);

            HttpEntity<String> entity = new HttpEntity<>(bankJson, headers);

            ResponseEntity<MessageResponse> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, MessageResponse.class);

            MessageResponse messageResponse = response.getBody();

            assert messageResponse != null;
            model.addAttribute("message", messageResponse.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Error processing bank details.");
        }

        return "addBank";
    }
    @GetMapping("/updateBank")
    public String updateBank(Model model) {
        model.addAttribute("bankDTO", new BankDTO());
        return "updateBank";
    }
    @PutMapping("/updateBank")
    public String updateBank(@ModelAttribute("bankDTO") BankDTO bank, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/v1/swift-codes/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String bankJson = objectMapper.writeValueAsString(bank);

            HttpEntity<String> entity = new HttpEntity<>(bankJson, headers);

            ResponseEntity<MessageResponse> response = restTemplate.exchange(apiUrl, HttpMethod.PUT, entity, MessageResponse.class);

            MessageResponse messageResponse = response.getBody();

            assert messageResponse != null;
            model.addAttribute("message", "Bank updated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Error processing bank details.");
        }

        return "updateBank";
    }
    @GetMapping("/deleteBank")
    public String deleteBank() {

        return "deleteBank";
    }
    @PostMapping("/deleteBank")
    public String deleteBank(@RequestParam("swiftCode") String swiftCode, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/v1/swift-codes/" + swiftCode;
        restTemplate.exchange(
                apiUrl,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        model.addAttribute("message", "Bank deleted successfully.");

        return "deleteBank";
    }

}
