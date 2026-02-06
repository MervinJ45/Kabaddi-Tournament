package study.abstractclasses;

public class ClassBB extends AbstractClassA {
    public static void main(String[] args) {
        ClassBB cls = new ClassBB();
        cls.method();
    }

    public void method() {
        a++;
        System.out.println(a);
    }
}
