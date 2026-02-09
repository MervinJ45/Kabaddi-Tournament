package study.studygenerics;

public class GenericListClass {
    public static void main(String[] args) {
        GenericList<String> stringList = new GenericList<>();
        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");
        System.out.println(stringList.getList());
//        stringList.sum(stringList.getList());

        GenericList<Integer> integerList = new GenericList<>();
        //type error during compile time itself
        // integerList.add("FF");
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println(integerList.getList());
        integerList.sum(integerList.getList());
    }
}
