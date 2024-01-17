package ca.bytetube.day15_collection.HashSet;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("bbb");
        set.add("aaa");
        set.add("ccc");

        for (String s : set) {
            System.out.println(s);
        }

        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
