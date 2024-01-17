package ca.bytetube.day15_collection;

public class MyGenericMethod {

    public <T> void show(T mvp) {
        System.out.println(mvp.getClass());
    }


    public <MVP> MVP show2(MVP mvp) {
        return mvp;
    }

    public static void main(String[] args) {
        //创建对象
        MyGenericMethod mm = new MyGenericMethod();

        //演示看方法提示
        mm.show("bytetube");//class java.lang.String
        mm.show(123);//class java.lang.Integer
        mm.show(12.45);//class java.lang.Double
    }


}
