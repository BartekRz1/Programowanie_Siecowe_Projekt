package API.SWIFT.dto;


import java.util.List;

public class HeadquarterResponseDTO {
    private String address;
    private String bankName;
    private String countryISO2;
    private String countryName;
    private String swiftCode;
    private List<BranchResponseDTO> branches;

    public HeadquarterResponseDTO(String address, String bankName, String countryISO2, String countryName, String swiftCode, List<BranchResponseDTO> branches) {
        this.address = address;
        this.bankName = bankName;
        this.countryISO2 = countryISO2;
        this.countryName = countryName;
        this.swiftCode = swiftCode;
        this.branches = branches;
    }
    public HeadquarterResponseDTO(String address, String bankName, String countryISO2, String countryName, String swiftCode) {
        this.address = address;
        this.bankName = bankName;
        this.countryISO2 = countryISO2.toUpperCase();
        this.countryName = countryName.toUpperCase();
        this.swiftCode = swiftCode;
    }

    public HeadquarterResponseDTO() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCountryISO2() {
        return countryISO2;
    }

    public void setCountryISO2(String countryISO2) {
        this.countryISO2 = countryISO2.toUpperCase();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName.toUpperCase();
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public List<BranchResponseDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchResponseDTO> branches) {
        this.branches = branches;
    }
}
