package ca.bytetube.day11_static;

import java.util.ArrayList;

/**
 * static
 * 1. 修饰变量 ---> 静态变量 = 类变量， 不仅仅属于对象，而是属于类，可以通过类名.静态变量（public）
 * 2. 修饰方法 ---> 静态方法，不仅仅属于对象，而是属于类，可以通过类名.静态方法（public）
 * 3. 静态方法中不能调用成员方法，而在成员方法中可以调用静态方法和静态变量
 * 4. 静态变量，静态方法更多的是属于类，希望通过类来进行调用
 * 5. 静态变量，静态方法存放在静态区，只有唯一的一份，对所有的对象共享
 * 6. 静态代码块，初始化静态变量，优先于main函数和构造方法的调用
 */

public class Student {
    private String name;
    private int age;
    private int sid;
    public static int numOfStudent = 0;//一般被static修饰的数据，是共享状态，设置为共有public

    public static ArrayList<Student> students;
//    static{
//        //初始化静态变量
//        students = new ArrayList<>();
//        students.add(new Student("fang", 26));
//
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSid() {
//        show();//成员方法中可以调用静态方法
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        sid = ++numOfStudent;
//        System.out.println(numOfStudent);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sid=" + sid +
                '}';
    }

    public static void show(){
        System.out.println(numOfStudent);//静态方法中只能调用静态变量or静态方法
        //原因：所属关系不同，static关键字所修饰的变量和方法属于类，成员变量和成员方法属于对象

//        System.out.println(name);//不能在静态方法中调用成员变量
//        getSid();//不能在静态方法中调用成员方法
    }

    public static void main(String[] args) {
//        Student student1 = new Student("fang", 26);
//        Student.show();
//        Student student2 = new Student("huan",6);
//        Student.show();
//        Student student3 = new Student("shuo", 36);
//        Student.show();
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
//        Student.show();//类直接调用静态方法
//        student1.show();//对象可以调用静态方法，但不建议
        System.out.println(Student.students);

    }
}
