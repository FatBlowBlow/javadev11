package ca.bytetube.day09;

/**
 * JavaBean 标准代码
 */

public class User {
    //成员变量，private
    private String name;
    private String address;
    private int age;
    private double salary;

    //构造方法
    //无参数构造方法（必须）
    public User() {}
    //有参数构造方法（建议）
    public User(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    //成员方法（对每一个成员属性）
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {//直接打印对象
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
