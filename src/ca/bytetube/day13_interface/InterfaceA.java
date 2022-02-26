package ca.bytetube.day13_interface;

public interface InterfaceA {

    /**
     * 接口定义常量：
     * 1. 用大写字母
     * 2. 修饰符: public or 不写
     */
    public static final int NUM = 10;

    public abstract void showA();

    public abstract void show();

    public default void methodA(){
        System.out.println("default methodA in A");
    };

    public default void method(){
        System.out.println("default method in InterfaceA");
    };
}
