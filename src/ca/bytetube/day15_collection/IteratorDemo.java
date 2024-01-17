package ca.bytetube.day15_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {

        Collection<String> coll = new ArrayList<>();

        coll.add("fang");
        coll.add("shuo");
        coll.add("huan");
        coll.add("jun");

        //遍历
        //获取集合的迭代器
        Iterator<String> it = coll.iterator();

        while (it.hasNext()){//判断是否有迭代元素
            String s = it.next();//获取迭代出的元素
            System.out.println(s);
        }
    }
}
