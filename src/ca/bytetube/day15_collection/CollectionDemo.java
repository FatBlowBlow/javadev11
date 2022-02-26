package ca.bytetube.day15_collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

    public static void main(String[] args) {

        Collection<String> coll = new ArrayList<String>(); // 􏰟􏰠􏳁􏳂
        coll.add("bytetube");
        coll.add("dal");
        coll.add("tony");
        System.out.println(coll);

        //boolean contains(E e) 􏳋􏳌o􏰥􏳍􏰒􏰄􏰅􏰩􏰲
        System.out.println("􏳋􏳌 判断bytetube是否在集合中 􏰥􏳍􏰒􏰄􏰅􏰩"+ coll.contains("bytetube"));

        //boolean remove(E e) 􏳉􏳊􏰒􏰄􏰅􏰩􏰬o􏱋
        System.out.println("􏳉􏳊删除dal􏰨:"+coll.remove("dal"));
        System.out.println("􏱰􏱱􏱹􏴂􏰄􏰅􏰩􏱋􏱌操作之后集中元素:"+coll);


        //size() 􏰄􏰅􏰩􏰿􏴃􏰵􏱋􏱌集合中有几个元素
        System.out.println("􏰄􏰅􏰩􏰿集合中有"+coll.size()+"􏰵􏱋􏱌个元素");

        //Object[] toArray()􏴄􏴅􏳳􏰎􏰵 转换成一个Object􏰶􏰺数组
        Object[] objects = coll.toArray();
        //遍历数组
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //void clear() 􏳇􏳈􏰄􏰅清空集合
        coll.clear();
        System.out.println("􏰄􏰅􏰩􏰂􏰃􏲇􏰨集合中内容为"+coll);

        //boolean isEmpty() 􏳋􏳌􏰥􏳍􏲇􏳈判断是否为空
        System.out.println(coll.isEmpty());

    }
}
