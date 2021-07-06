package ca.bytetube._09_hashTable;

public class Person extends Object {

    private int age;
    private float height;
    private String name;


    public Person() { }


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

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }


    public static void main(String[] args) {
        Person p1 = new Person(50,16.7f, "jack");
        Person p2 = new Person(45,17.8f, "pony");
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}
