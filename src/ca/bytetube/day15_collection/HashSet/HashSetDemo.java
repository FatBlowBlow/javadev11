package ca.bytetube.day15_collection.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("bcd");
        set.add("cde");
        set.add("abc");

        //元素无序且不重复
        for (String s: set) {
            System.out.println(s);
        }
    }
}
