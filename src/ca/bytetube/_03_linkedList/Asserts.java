package ca.bytetube._03_linkedList;

public class Asserts {//Junit中有asserts方法用来判断是否相等
    public static void test(boolean value){

       try {
           if(! value) throw new Exception("test not pass");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
