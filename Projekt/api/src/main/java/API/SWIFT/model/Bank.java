package API.SWIFT.model;

import jakarta.persistence.*;

@Entity
public class Bank {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "country_iso2")
    private String countryISO2;
    @Column(name = "swift_code")
    private String swiftCode;
    @Column(name = "code_type")
    private String codeType;
    @Column(name = "bank_name")
    private String bankName;
    private String address;
    @Column(name="town_name")
    private String townName;
    @Column(name="time_zone")
    private String timeZone;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "is_headquarter")
    private boolean isHeadquarter;

    public Bank(String countryISO2, String swiftCode, String codeType, String bankName, String address, String townName, String timeZone, String countryName, boolean isHeadquarter) {
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

    public Bank() {

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

