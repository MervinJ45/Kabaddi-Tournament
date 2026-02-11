package study.hascodeandequals;

public class EqualsInString {
    public static void main(String[] args) {
        String st1 = "String";
        String st2 = new String("String");
        //.equals() check the memory of both the string object first
        //then it checks the value
        System.out.println(st1.equals(st2));
    }

}
