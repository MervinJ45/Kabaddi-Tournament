package study;

public interface InterfaceB {
    public static final int a = 20;

    default void print() {
        System.out.println(a);
    }

    static void scan() {
        System.out.println("scanB");
    }
}
