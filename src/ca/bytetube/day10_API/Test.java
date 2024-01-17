package ca.bytetube.day10_API;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("fang", 26);
        Student student2 = new Student("huan",6);
        Student student3 = new Student("shuo", 36);
        Student student4 = new Student("jun", 18);
        ArrayList<Student> arrayList = new ArrayList<>(3);//Default initial capacity=10
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);
        System.out.println(arrayList);
        arrayList.add(student4);
        System.out.println(arrayList);
//        Student[] arr = new Student[3];
//        arr[0] = student1;
//        arr[1] = student2;
//        arr[2] = student3;

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i].getName());
//        }
//        System.out.println("===================================");
//        Student student4 = new Student("jun", 18);
//        //1.扩容 --->创建一个更大的数组
//        Student[] newArr = new Student[4];
//        //2.将原数组中的数据迁移到新数组中，并把最新的元素追加到新容器中
//        for (int i = 0; i < arr.length; i++) {
//            newArr[i] = arr[i];
//        }
//        newArr[3] = student4;
//        arr = newArr;
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i].getName());
//        }
    }
}
