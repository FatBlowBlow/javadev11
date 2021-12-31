package ca.bytetube.day09;

/**
 * 3种方式对类成员变量进行初始化
 * 1.obj.attribute = xxx(attribute not private, not safe)
 * 2.setXX(XX xx) --> 使用private关键字来修饰成员变量
 * 3.构造方法（函数），Constructor
 * Later......
 * 4.反射（.class)
 * 5.design pattern
 */

public class Test {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName ("fang");
        user1.setAge (5);
        user1.setAddress ("mtl");
        System.out.println(user1);
        //System.out.println(user1.getName() + "," + user1.getAge() + "," + user1.getAddress());
        User user2 = new User("fang","mtl", 5);
        System.out.println(user2);
       // System.out.println(user2.getName() + "," + user2.getAge() + "," + user2.getAddress());










//          Student student = new Student();
//          System.out.println(student);//4617c264
////        System.out.println(student.age);//没有初始化的话， 值为0
////        System.out.println(student.name);//没有初始化的话， 值为null
//          System.out.println(student.getAge());
//          System.out.println(student.getName());
//
//          System.out.println("==========================");
//
//
//          student.setAge(5);
//          student.setName("bytetube");
//
//          System.out.println(student.getAge());
//          System.out.println(student.getName());
//
//          //初始化 --> obj.attribute = xxx
////        student.age = 5;
////        student.name = "bytetube";
////        System.out.println(student.age);
////        System.out.println(student.name);
//
//
//
//        Phone p = new Phone();//创建对象
//        //赋值 --> obj.attribute = xxx
//        p.brand = "apple";
//        p.price = 1200.79;
//        p.color = "grey";
//
//
//        Phone p1 = new Phone();//创建对象
//        //赋值 --> obj.attribute = xxx
//        p1.brand = "huawei";
//        p1.price = 1000.79;
//        p1.color = "black";
//
//        //调用方法
//        //一个对象调用一个方法
//        p.call("bytetube");
//
//        //两个对象调用同一个方法
//        p.call("bytetube");
//        p1.call("fang");
//
//        //一个引用，作为参数传递到方法中，传递的是地址值
//        p.show(p);





    }





}
