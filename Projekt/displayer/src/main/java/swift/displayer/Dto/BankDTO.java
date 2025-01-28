package swift.displayer.Dto;

public class BankDTO {

    private String countryISO2;
    private String swiftCode;
    private String codeType;
    private String bankName;
    private String address;
    private String townName;
    private String timeZone;
    private String countryName;
    private boolean isHeadquarter;

    public BankDTO(String countryISO2, String swiftCode, String codeType, String bankName, String address, String townName, String timeZone, String countryName, boolean isHeadquarter) {
        this.countryISO2 = countryISO2.toUpperCase();
        this.swiftCode = swiftCode;
        this.codeType = codeType;
        this.bankName = bankName;
        this.address = address;
        this.townName = townName;
        this.timeZone = timeZone;
        this.countryName = countryName.toUpperCase();
        this.isHeadquarter = isHeadquarter;
    }

    public BankDTO() {

    }

    public String getCountryISO2() {
        return countryISO2;
    }

    public void setCountryISO2(String countryISO2) {
        this.countryISO2 = countryISO2;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isHeadquarter() {
        return isHeadquarter;
    }

    public void setHeadquarter(boolean headquarter) {
        isHeadquarter = headquarter;
    }
}



