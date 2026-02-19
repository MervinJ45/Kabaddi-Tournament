package study.mappinginheritedobjs;

import study.annotations.FieldOf;

public class Human {
    @FieldOf(value = "Name")
    private String name;
    @FieldOf(value = "Age")
    private int age;

    public Human() {

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
