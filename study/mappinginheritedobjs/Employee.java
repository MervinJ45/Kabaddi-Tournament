package study.mappinginheritedobjs;

import objtoobjconversion.Address;
import study.annotations.FieldOf;

public class Employee extends Human {
    @FieldOf(value = "MobileNumber")
    private String mobileNumber;
    @FieldOf(value = "Address")
    private Address address;

    public Employee() {
        super();
    }

    public Employee(String name, int age, String mobileNumber, Address address) {
        super(name, age);
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
