package API.SWIFT.controller;

import API.SWIFT.dto.MessageResponse;
import API.SWIFT.model.Bank;
import API.SWIFT.repository.BankRepository;
import API.SWIFT.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/swift-codes")
@RestController
public class SwiftController {
    private final BankService bankService;
    private final BankRepository bankRepository;

    public SwiftController(BankService bankService, BankRepository bankRepository) {
        this.bankService = bankService;
        this.bankRepository = bankRepository;
    }

    @GetMapping("/{swift-code}")
    public ResponseEntity<?> swiftCode(@PathVariable("swift-code") String swiftCode) {
        return bankService.getBankBySwiftCode(swiftCode);
    }
    @GetMapping("/")
    public ResponseEntity<?> swiftCodes() {
        return bankService.getAllBanks();
    }
    @PostMapping("/")
    public ResponseEntity<MessageResponse> addBank(@RequestBody Bank bank) {
        return bankService.addBank(bank);
    }
    @PutMapping("/")
    public ResponseEntity<MessageResponse> updateBank(@RequestBody Bank bank) {
        return bankService.updateBank(bank);
    }
    @DeleteMapping("/{swift-code}")
    public ResponseEntity<MessageResponse> deleteBank(@PathVariable("swift-code") String swiftCode) {
        Bank bank = bankRepository.findBySwiftCode(swiftCode);
        return bankService.deleteBank(bank);
    }

}
