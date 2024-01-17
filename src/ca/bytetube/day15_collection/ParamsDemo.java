package ca.bytetube.day15_collection;

public class ParamsDemo {

    /**
     *  可变参数,底层是数组.
     *  int... num = int[] num
     *  优点: 不用创建数组，可以直接传递数据
     */
    public static int add(int... num){
        int res = 0;
        for (int i: num) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(add(10,11,20,88));
    }
}
