package ca.bytetube._06_binaryTree;

public class Person implements Comparable<Person> {//实现comparable接口
    private int age;
    private double salary;
    private String name;


//    public Person(int age) {
//        this.age = age;
//    }

    public Person(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "salary=" + salary +
                '}';
    }
}
