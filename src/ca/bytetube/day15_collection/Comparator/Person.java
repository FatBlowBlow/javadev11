package ca.bytetube.day15_collection.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * 自定义类的排序规则，参数之间指定的比较规则:
 *
 * 1. 传入比较器comparator
 *    实现 Comparator 接口,重写 compare() 方法
 *
 * 2. 如果不想传 比较器comparator， 则类要实现 Comparable 接口， 使类具备可比较性
 *    当一个类实现 Comparable 接口,重写了 compareTo() 方法时,类就具备了可比较性
 *
 *    升序排 o1 - o2, 第一个数 - 第二个数
 *    降序排 o2 - o1, 第二个数 - 第一个数
 */

public class Person implements Comparable<Person> {

    public String name;
    public int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {//站在第一视角，跟另外一个人比， 只传另一个人的参数
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, new Person("fang", 26),
                new Person("huan", 6),new Person("shuo", 26),
                new Person("jun", 52),new Person("sheng", 26));

        System.out.println(arrayList);

//        Collections.sort(arrayList, new Comparator<Person>() {//匿名内部类
//            @Override
//            public int compare(Person o1, Person o2) {//站在第三视角，看两个人比较，传两个参数
//                return o1.age - o2.age;
//            }
//        });

        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

}
