package ca.bytetube.day12_inheritance;

public class Tester extends Employee {

    public Tester(String name, Double salary, String id) {
        super(name, salary, id);
    }

    @Override
    public void work(){
        System.out.println("testing and finding bugs");
    }
}
