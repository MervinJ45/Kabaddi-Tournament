package study.studygenerics;

public class CustomGenericClass {
    public static void main(String[] args) {
        //type passed as parameter
        CustomGeneric<String> cg1 = new CustomGeneric<>("Name", "City", "State");
        System.out.println(cg1.getT1());
        System.out.println(cg1.getT2());
        System.out.println(cg1.getT3());

        CustomGeneric<Integer> cg2 = new CustomGeneric<>(1, 2, 3);
        System.out.println(cg2.getT1());
        System.out.println(cg2.getT2());
        System.out.println(cg2.getT3());
    }
}
