package study.interfaces;

public interface InterfaceA {
    public static final int a = 10;

    default void print() {
        System.out.println(a);
    }

    static void scan() {
        System.out.println("scanA");
    }
}
