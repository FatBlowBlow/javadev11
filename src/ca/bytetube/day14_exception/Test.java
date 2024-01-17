package ca.bytetube.day14_exception;

public class Test {

    //1. 声明抛出，异常抛出
    public static void main(String[] args) throws NoAgeException {
        Person p = new Person("fang", 20);
        System.out.println(p);
    }

    //2. 捕获处理：对异常进行try/catch处理
//    public static void main(String[] args)  {
//        Person p = null;
//        try {
//            p = new Person("fang", 201);
//        } catch (NoAgeException e) {
//            e.printStackTrace();
//        }
//        System.out.println(p);
//    }
}
