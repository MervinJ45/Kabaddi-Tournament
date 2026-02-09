package study.studygenerics;

import java.util.ArrayList;

public class GenericList<T> {
    private ArrayList<T> list;

    GenericList() {
        list = new ArrayList<>();
    }

    //generic method
    public void add(T t) {
        list.add(t);
    }

    public ArrayList<T> getList() {
        return list;
    }

    //using bounded type parameter
    public <U extends Number> void sum(ArrayList<U> list) {
        int sum = 0;
        for (Number el : list) {
            sum = sum + (int) el;
        }
        System.out.println(sum);
    }
    //using upperbound parameter
//    public void sum(ArrayList<? extends String> list){
//        String res = "";
//        for(String el : list){
//            res += el+"-";
//        }
//        System.out.println(res);
//    }
}
