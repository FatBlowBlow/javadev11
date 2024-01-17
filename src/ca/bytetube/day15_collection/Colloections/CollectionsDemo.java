package ca.bytetube.day15_collection.Colloections;


import java.util.ArrayList;
import java.util.Collections;


/**
 * collections 集合的工具类，对集合进行操作
 */

public class CollectionsDemo {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

//        //addAll()
//        Collections.addAll(arrayList, 1, 10, 100, 1000);
//        System.out.println(arrayList);
//
//        //shuffle()
//        Collections.shuffle(arrayList);
//        System.out.println(arrayList);
//
//        //单参数sort()
//        Collections.sort(arrayList);
//        System.out.println(arrayList);

        ArrayList<String> sList = new ArrayList<>();
        Collections.addAll(sList, "ab", "bc", "abc");
        System.out.println(sList);
        Collections.shuffle(sList);
        System.out.println(sList);
        Collections.sort(sList);//string类型按字典序排序
        System.out.println(sList);


    }
}
