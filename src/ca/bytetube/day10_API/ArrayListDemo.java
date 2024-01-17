package ca.bytetube.day10_API;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
//        ArrayList arrayList = new ArrayList();//不去声明元素类型时，什么类型都可以加
//        arrayList.add(10);
//        arrayList.add(9.8);
//        arrayList.add("huan");
//        arrayList.add(new Student("fang", 26));
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }

        ArrayList<String> arrayList = new ArrayList();

        arrayList.add("huan");//index = 0
        arrayList.add("fang");//index = 1
        arrayList.add(1,"jun");
        System.out.println(arrayList.get(1));//jun
        System.out.println(arrayList.size());//3
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

//        String removed = arrayList.remove(1);
//        System.out.println("data removed :" + removed);
//        System.out.println();
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }

        Boolean removed = arrayList.remove("jun");
        System.out.println("data removed :" + removed);
        System.out.println();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
