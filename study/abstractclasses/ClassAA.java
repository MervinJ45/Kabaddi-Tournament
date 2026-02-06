package study.abstractclasses;

public class ClassAA extends AbstractClassA {
    public static void main(String[] args) {
        ClassAA cls = new ClassAA();
        cls.method();
    }

    public void method() {
        a += 10;
        System.out.println(a);
    }
}
