package ca.bytetube.day13_interface;

public interface Tools {

    public abstract void func1();

    public static void func2(){
        System.out.println("this is a static method");
    };

    public default void func3(){
        System.out.println("this is a default method");
    }
}
