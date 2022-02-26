package ca.bytetube.day12_inheritance;

//Developer 继承了 Employee
//Developer is a/an employee
//子类可以获取父类所有的 非私有的属性和行为

public class Developer extends Employee {

    public Developer(String name, Double salary, String id) {
        super(name, salary, id);
    }

    public void printName() {
        System.out.println("name:" + this.name);
    }

    @Override
    public void work(){
        System.out.println("coding ......debugging.....");
    }

    public static void main(String[] args) {
        Developer developer = new Developer("fang",100.00,"1");
        developer.name = "bytetube";


        developer.work();
    }
}
