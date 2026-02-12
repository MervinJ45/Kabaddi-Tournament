package study.optional;

import java.util.Optional;

public class OptionalStudy {
    public static void main(String[] args) {
        //creates an optional that contains value
        //if there is null it will throw NullPointerException
        //Optional can hold only one value or empty
        Optional<String> name = Optional.of("Rohit");
        System.out.println(name);
        System.out.println(name.get());
        //will throw NullPointerException
        //Optional<String> name = Optional.of(null);
    }
}
