package ca.bytetube.day12_inheritance;


/**
 * 抽象类中，不一定包含抽象方法
 * 如果一个类中包含抽象方法，这个类必须是抽象类
 */
public abstract class Employee {
    String name;
    double salary;
    String id;

    public Employee(String name, Double salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public abstract void work();//抽象方法没有方法体{}

    public void func(){
        System.out.println("jhhhh");
    }

//    public static void main(String[] args) {
//        Employee employee = new Employee();
//    }
}
