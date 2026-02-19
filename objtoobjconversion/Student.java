package objtoobjconversion;

import study.annotations.*;

public class Student {
    @FieldOf(value = "Name")
    private String name;
    @FieldOf(value = "Age")
    private int age;
    @FieldOf(value = "MobileNumber")
    private String mobileNumber;
    @FieldOf(value = "Address")
    private Address address;

    public Student() {

    }

    public Student(String name, int age, String mobileNumber, Address address) {
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

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
