package study.studygenerics;

public class GenericMapClass {
    public static void main(String[] args) {
        GenericMap<Integer, String> genericMap = new GenericMap<>();
        genericMap.put(1, "ONE");
        genericMap.put(2, "TWO");
        genericMap.put(3, "THREE");
        System.out.println(genericMap.getMap());
    }
}
