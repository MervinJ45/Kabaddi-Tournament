package study.functionalinterface;

public class FunctionalInterfaceImplementation {
    public static void main(String[] args) {
        //functional interface usage
        study.functionalinterface.FunctionalInterface addition = (a, b) -> a + b;
        study.functionalinterface.FunctionalInterface subtraction = (a, b) -> a - b;
        int res = addition.add(5, 10);
        int result = subtraction.add(10, 5);
        System.out.println(res+" "+result);
        //static method from interface
        study.functionalinterface.FunctionalInterface.printStatic(1,2);
    }
    public class InnerClass implements FunctionalInterface {
        public int add(int a,int b){
            //default method from interface
            printDefault(1,2);
            return 0;
        }
    }

}
