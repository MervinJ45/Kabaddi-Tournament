package study.functionalinterface;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    int add(int a, int b);
    //second abstract method not allowed
    //int sub();

    //multiple default and static methods are allowed
    default void printDefault(int a, int b) {
        System.out.println("default");
    }

    static void printStatic(int a, int b) {
        System.out.println("static");
    }
}
