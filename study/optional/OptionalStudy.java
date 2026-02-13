package study.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalStudy {
    public static void main(String[] args) {
        //creates an optional that contains value
        //if there is null it will throw NullPointerException
        //Optional can hold only one value or empty
        //Optional can't hold primitive data type only Objects
        Optional<String> name = Optional.of("Rohit");
        System.out.println(name);
        System.out.println(name.get());
        //will throw NullPointerException
        //Optional<String> name = Optional.of(null);
        Integer a = null;
        Optional<Integer> age = Optional.ofNullable(a);
        System.out.println(age);
        //get() Optional of null results in NoSuchElementException
        //System.out.println(age.get());
        int b = 5;
        //int is autoboxed into Integer to be passed into Optional
        Optional<Integer> num = Optional.ofNullable(b);
        System.out.println(num);
        System.out.println(num.get());
        //setting an optional as empty
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        //throws NoSuchElementException
        //System.out.println(empty.get());
        //isPresent() will check whether the optional is null or not
        System.out.println(empty.isPresent());
        System.out.println(num.isPresent());
        //isEmpty checks whether the Optional is empty or not
        System.out.println(empty.isEmpty());
        System.out.println(num.isEmpty());
        //orElse will specify the value of Optional if it is null
        String str = empty.orElse("OrElse Empty");
        System.out.println(str);
        //orElseGet will accept only supplier
        Supplier<String> supplier = ()-> "OrElseGet Empty";
        System.out.println(empty.orElseGet(supplier));
        //by default throws NoSuchElementException if the optional is null
        //empty.orElseThrow();
        //can specify what exception can be thrown if the optional is null
        //empty.orElseThrow(()-> new RuntimeException());
        //conditional execution will accept only consumer
        Consumer<String> consumer = (string) -> System.out.println(string);
        name.ifPresent(consumer);
        empty.ifPresent(string -> System.out.println(string));
        //ifPresentOrElse will execute the first consumer if the Optional is present or else the second one
        //Optional with null
        empty.ifPresentOrElse(
                string -> System.out.println("Optional is present "+string),
                () -> System.out.println("Optional Not Present")
        );
        //Optional with value
        name.ifPresentOrElse(
                string -> System.out.println("Optional is present "+string),
                () -> System.out.println("Optional Not Present")
        );
        String[] arr = new String[]{"Rohit", null, "Virat", "Rahul"};
        //.map will perform the operation only on not null values
        for(int i=0;i<arr.length;i++){
            Optional<String> player = Optional.ofNullable(arr[i]);
            Optional<Integer> length = player.map(p->p.length());
            System.out.println(length);
        }
        //flatMap is used when the function performed will already return an Optional
        for(int i=0;i<arr.length;i++){
            Optional<String> player = Optional.ofNullable(arr[i]);
            Optional<String> playerUpper = player.flatMap(p->Optional.of(p.toUpperCase()));
            System.out.println(playerUpper);
        }
        //filter return empty Optional if the condition is not met or the Optional itself
        String[] filteredArr = new String[arr.length];
        int z=0;
        for(int i=0;i<arr.length;i++){
            Optional<String> player = Optional.ofNullable(arr[i]);
            Optional<String> filtered = player.filter(p->p.startsWith("R"));
            if(filtered.isPresent()){
                filteredArr[z++] = filtered.get();
            }
        }
        for(String st: filteredArr){
            System.out.println(st);
        }
    }
}
