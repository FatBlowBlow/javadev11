package ca.bytetube._11_recursion;

/**
 * jvm不能改变frame的大小， 所以Java不支持tail call
 * 但支持tail recursion
 */

public class TailCall {


    public void test1(){
        int a = 10;
        int b = 10 + a;
        test2();
        int c = a + b;

    }

    public void test2(){
        int x1 = 20;
        int x2 = 30;

    }

    public void test(int n){
        if (n < 0) return;
        System.out.println("test-" + n);
        test(n - 1);
    }

    public void test3(int n){
        if (n < 0) return;
        while(n >= 0){
            System.out.println("test-" + n);
            n--;
        }
    }

    public static int factorial2(int n){
        if (n <= 1) return n;
        return n * factorial2(n - 1);
    }

    //把以上code改为tail recursion

    public static int factorial(int n){


        return factorial(n,1);
    }

    private static int factorial(int n, int res) {
        if (n <= 1) return res;
        return factorial(n - 1, res * n );
    }

    public static void main(String[] args) {
        System.out.println(factorial2(5));
        System.out.println(factorial(5));
    }


}
