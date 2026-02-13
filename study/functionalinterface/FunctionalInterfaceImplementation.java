package study.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        //predicate is a functional interface that takes one input and gives a boolean value as output
        Predicate<Integer> isEven = (i)-> i%2==0;
        System.out.println(isEven.test(2));
        System.out.println(isEven.test(3));

        //takes one argument and doesn't return anything
        //input type Integer
        Consumer<String> print = (string)-> System.out.println(string);
        print.accept("Hi");

        //takes two arguments and produces an output
        //input type Integer and output type also Integer (Specified)
        Function<Integer,Integer> add = (a)-> a+10;
        System.out.println(add.apply(10));

        //Supplier doesn't take any input and returns something
        //here the return type is specified as integer
        Supplier<Integer> ret = ()-> 2;
        System.out.println(ret.get());
    }
}