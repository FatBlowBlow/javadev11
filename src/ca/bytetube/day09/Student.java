package ca.bytetube.day09;

public class Student {
    //成员变量_member variable / attribute (属性)
    private String name;
    private int age;

    //成员方法_member methods(行为)
    public void study(){
        System.out.println("coding makes me happy!");
    }

    public void eat(){
        System.out.println("I love burger！");
    }


    //对类成员变量进行初始化

    //1.obj.attribute = xxx(attribute not private, not safe)
    //   student.age = 5;
    //   student.name = "bytetube";
    //   System.out.println(student.age);
    //   System.out.println(student.name);

    //2. setXX(XX xx)
    public void setName(String name) {
        this.name = name;//this --> obj,当前调用setName这个方法的对象
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getAge() {
        return age;
    }


    //3.构造方法
    //构造方法名必须是类名
    //构造方法可以重载，即参数列表不同（不定义参数/定义一个参数or两个参数）

    //3.1 无参数构造方法（不定义参数）
    public Student() {//无参构造一定要！
    }

    //3.2 有参数构造方法（定义一个参数or两个参数）
    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
