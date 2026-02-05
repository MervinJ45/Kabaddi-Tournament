package study;

public class ClassA implements InterfaceA, InterfaceB {

    public static void main(String[] args) {
        //accessing variables of interface(static final)
        System.out.println(InterfaceA.a);
        System.out.println(InterfaceB.a);
        ClassA cls = new ClassA();
        cls.print();
    }


    @Override
    //overriding default method(avail in both implemented interfaces)
    public void print() {
        //accessing default methods
        InterfaceA.super.print();
        InterfaceB.super.print();
        //accessing static methods in interface
        InterfaceA.scan();
        InterfaceB.scan();
    }
}
