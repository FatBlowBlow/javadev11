package ca.bytetube.day12_inheritance;

public class SuperClass extends Object{
    int num = 5;
    int superAttr;


    public SuperClass(int superAttr) {
        this.superAttr = superAttr;
    }


    public SuperClass() {
        System.out.println("SuperClass Constructor");
    }


    public void show(){
        System.out.println("superClass show");
    }

}
