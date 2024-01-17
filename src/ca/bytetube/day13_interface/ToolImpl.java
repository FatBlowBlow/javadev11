package ca.bytetube.day13_interface;


/**
 * interface ----> rules
 */
public class ToolImpl implements Tools {
    @Override
    public void func1() {
        System.out.println("this is ToolImpl method");
    }

    @Override
    public void func3() {
        System.out.println("default method is override");
    }



    public static void main(String[] args) {
        ToolImpl tool = new ToolImpl();
        tool.func1();
        tool.func3();//可以调用接口的默认方法
        Tools.func2();//接口的静态方法只能被接口调用

    }
}
