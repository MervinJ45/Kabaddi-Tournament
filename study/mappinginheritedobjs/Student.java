package study.mappinginheritedobjs;

import objtoobjconversion.Address;
import study.annotations.FieldOf;

public class Student extends Human {
    @FieldOf(value = "MobileNumber")
    private String mobileNumber;
    @FieldOf(value = "Address")
    private Address address;

    public Student() {
        super();
    }


    public Student(String name, int age, String mobileNumber, Address address) {
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
