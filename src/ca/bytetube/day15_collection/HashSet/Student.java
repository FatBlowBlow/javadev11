package ca.bytetube.day15_collection.HashSet;

import java.util.HashSet;
import java.util.Objects;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    //通过重写equals方法，来确定元素是否已经存在
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        Student student1 = new Student("fang", 26);
        Student student2 = new Student("fang", 26);

        System.out.println(student1);//2503dbd3
        System.out.println(student2);//4b67cf4d
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        HashSet<Student> set = new HashSet<>();//HashSet对象会内部自动调equals方法
        set.add(student1);
        set.add(student2);
        System.out.println(set.size());


    }
}
