package ca.bytetube._09_hashTable;

import java.util.*;

public class Person extends Object {//Java中任何一个类都是Object的子类
    private int age;
    private float height;
    private String name;


    public Person() {}


    public Person(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    /**
     * 重写equals的目的：当发生了哈希冲突时，用来比较2个key是否相同，如果key相同发生覆盖
     *
     * 假设有一个index的位置上连接了多个node（bucket）
     * 这时我们新插入一个key，让他去生成自己的hashcode，生成的hashcode通过%运算得到的bucket array对应的index
     * 假设新的key所对应的index和之前的key所对应的index是相同的
     * 既然index是相同的，我们需要拿到这个key和list上多个node（bucket）所对应的key进行比较
     * 如果是同一个key，就发生覆盖
     * 如果不相同，在list后边进行追加
     *
     * 那，在jdk的HashMap中 为什么不直接拿hashcode来进行比较来确定是否是同一个对象？
     * 原因：
     * 1.不同type数据可能对应相同的hashcode值
     * 2.同一类数据也有可能对应相同的hashcode值 [50,16.7f, "jack"]  [23,15.8f, "jobs"]
     */
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;//不同的

        Person person = (Person) obj;//重写父类，需要强转
        return person.age == this.age && person.height == this.height &&
                (person.name == null? name == null : person.name.equals(this.name));

    }



    @Override
    public int hashCode(){//仿照String类型， 重写自定义Person类的hashcode
//        private int age;
//        private float height;
//        private String name;

        int hashCode = Integer.hashCode(age);
        hashCode = hashCode * 31 + Float.hashCode(height);
        hashCode = hashCode * 31 + (name != null ? name.hashCode() : 0);

        return hashCode;
    }


    public static void main(String[] args) {
        Person p1 = new Person(50,16.7f, "jack");
        Person p2 = new Person(45,17.8f, "pony");
        Person p3 = new Person(50,16.7f, "jack");
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
//        System.out.println(p1);
//        System.out.println(p3);

//        HashMap<Object, Object> hashMap = new HashMap<>();
//        hashMap.put(p1, "abc");
//        hashMap.put(p2, "bcd");
//        hashMap.put(p3, "ccc");
//        System.out.println(hashMap.size());
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map1 = new Hashtable<>();
        Set<Integer> map2 = new HashSet<>();
    }
}
