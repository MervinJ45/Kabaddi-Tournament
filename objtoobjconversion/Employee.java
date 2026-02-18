package objtoobjconversion;

import study.annotations.*;

public class Employee {
    @FieldOf(value = "name")
    private String name;
    @FieldOf(value = "age")
    private int age;
    @FieldOf(value = "mobileNumber")
    private String mobileNumber;
    @FieldOf(value = "address")
    private Address address;

    Employee() {

    }

    Employee(String name, int age, String mobileNumber, Address address) {
        this.name = name;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMobileNumber() {
        this.mobileNumber = mobileNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
