package API.SWIFT.dto;


public class BranchResponseDTO {
    private String address;
    private String bankName;
    private String countryISO2;
    private String countryName;
    private String swiftCode;

    public BranchResponseDTO(String address, String bankName, String countryISO2, String countryName, String swiftCode) {
        this.address = address;
        this.bankName = bankName;
        this.countryISO2 = countryISO2.toUpperCase();
        this.countryName = countryName.toUpperCase();
        this.swiftCode = swiftCode;
    }

    public BranchResponseDTO() {
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


}
