package objtoobjconversion;

public class Address {
    private int houseNo;
    private String streetName;
    private String districtName;
    private String stateName;

    Address(int houseNo, String streetName, String districtName, String stateName) {
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.districtName = districtName;
        this.stateName = stateName;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo=" + houseNo +
                ", streetName='" + streetName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
