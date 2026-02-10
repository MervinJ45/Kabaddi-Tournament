package study.studygenerics;

import java.util.ArrayList;

public class Wildcards<T> {
    private ArrayList<T> list;

    Wildcards() {
        list = new ArrayList<>();
    }

    public void add(T t) {
        list.add(t);
    }

    //Upperbound wildcards (takes all the types that extends from a specified objects, (accepts only the specified type and types that are extended from it, can read as Num))
    public void sum(ArrayList<? extends Number> list) {
        int sum = 0;
        for (Number el : list) {
            sum += (int) el;
        }
    }

    //unbounded wildcards (allows generic type of any element, accepts any type, can read as obj)
    public void summation(ArrayList<?> list) {
        int sum = 0;
        //access restriction
//        for(Number el : list){
//            sum += (int)el;
//        }
    }

    //Lowerbound wildcards allows only objects specified and the super classes of those objects, reads as obj
    public void addValues(ArrayList<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }
}
