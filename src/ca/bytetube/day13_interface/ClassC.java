package ca.bytetube.day13_interface;


/**
 * 实现类实现多个接口时:
 * 如果有同名的抽象方法，实现类只需要重写一次
 * 如果有同名的默认方法，必须重写一次
 */
public class ClassC extends ClassA implements InterfaceA {

    @Override
    public void method() {
        System.out.println("CCCCCCCC");
    }


    @Override
    public void showA() {
        System.out.println("AAAAAAAA");
    }



    @Override
    public void show() {
        System.out.println("CCCCCCCC");
    }





    public static void main(String[] args) {
        ClassC c = new ClassC();
//        c.show();
//        c.showA();
        c.method();

    }
}
