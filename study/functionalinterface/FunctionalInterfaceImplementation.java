package study.functionalinterface;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceImplementation {
    public static void main(String[] args) {
        //functional interface usage
        FunctionalInterface addition = (a, b) -> a + b;
        FunctionalInterface subtraction = (a, b) -> a - b;

        int res = addition.add(5, 10);
        int result = subtraction.add(10, 5);
        System.out.println(res + " " + result);

        addition.printDefault(1,2);
        //static method from interface
        FunctionalInterface.printStatic(1, 2);
    }
}