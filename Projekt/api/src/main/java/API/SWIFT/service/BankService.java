package API.SWIFT.service;

import API.SWIFT.dto.*;
import API.SWIFT.model.Bank;
import API.SWIFT.repository.BankRepository;
import org.apache.catalina.connector.Response;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {
    private final BankRepository bankRepository;
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
    public ResponseEntity<?> getBankBySwiftCode(String swiftCode) {
        Bank bank = bankRepository.findBySwiftCode(swiftCode);

        if (bank == null) {
            System.out.println("Bank not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no bank with swift code " + swiftCode);
        } else if (bank.isHeadquarter()) {
            HeadquarterResponseDTO headquarterDto = new HeadquarterResponseDTO();

            List<Bank> branches = bankRepository.findAllBranches(swiftCode.substring(0, swiftCode.length() - 3));
            List<BranchResponseDTO> branchResponseDtos = getBranchResponseDTOS(branches);

            headquarterDto.setAddress(bank.getAddress());
            headquarterDto.setBankName(bank.getBankName());
            headquarterDto.setCountryISO2(bank.getCountryISO2());
            headquarterDto.setCountryName(bank.getCountryName());
            headquarterDto.setSwiftCode(swiftCode);
            headquarterDto.setBranches(branchResponseDtos);
            return ResponseEntity.ok(headquarterDto);
        }
        else{
            BranchResponseDTO branchResponseDto = new BranchResponseDTO();
            branchResponseDto.setAddress(bank.getAddress());
            branchResponseDto.setBankName(bank.getBankName());
            branchResponseDto.setCountryName(bank.getCountryName());
            branchResponseDto.setCountryISO2(bank.getCountryISO2());
            branchResponseDto.setSwiftCode(swiftCode);
            return ResponseEntity.ok(branchResponseDto);
        }


    }

    private static List<BranchResponseDTO> getBranchResponseDTOS(List<Bank> branches) {
        List<BranchResponseDTO> branchResponseDtos = new ArrayList<>();
        for (Bank b : branches) {
            BranchResponseDTO branchResponseDto = new BranchResponseDTO();
            branchResponseDto.setAddress(b.getAddress());
            branchResponseDto.setBankName(b.getBankName());
            branchResponseDto.setCountryName(b.getCountryName());
            branchResponseDto.setCountryISO2(b.getCountryISO2());
            branchResponseDto.setSwiftCode(b.getSwiftCode());
            branchResponseDtos.add(branchResponseDto);
        }
        return branchResponseDtos;
    }
    public ResponseEntity<MessageResponse> addBank(Bank bank){
        if(bankRepository.findBySwiftCode(bank.getSwiftCode()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Bank already exists"));
        }
        bankRepository.save(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Bank successfully added"));
    }
    public ResponseEntity<MessageResponse> updateBank(Bank bank){
        if(bankRepository.findBySwiftCode(bank.getSwiftCode()) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Bank not found"));
        }
        bankRepository.save(bank);
        return ResponseEntity.ok(new MessageResponse("Bank successfully updated"));
    }
    public ResponseEntity<MessageResponse> deleteBank(Bank bank){
        if(bankRepository.findBySwiftCode(bank.getSwiftCode()) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Bank not found"));
        }
        bankRepository.delete(bank);
        return ResponseEntity.ok(new MessageResponse("Bank successfully deleted"));
    }
    public ResponseEntity<List<Bank>> getAllBanks(){
        List<Bank> banks = bankRepository.findAll();
        return ResponseEntity.ok(banks);
    }

}
