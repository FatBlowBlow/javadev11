package ca.bytetube._11_recursion;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */


public class Fib {

    public static void main(String[] args) {
        System.out.println(fib3(5));;
    }


    public static int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }


    public static int fib2(int n){//5
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        return fib2(n,arr);
    }

    private static int fib2(int n, int[] arr){
        if (arr[n] == 0) {//说明第n项 没有求过
            arr[n] = fib2(n-1, arr) + fib2(n-2,arr);
            //arr[5] = fib(4,arr)+ fib(3,arr); = 3+2 = 5
            //arr[4] = fib(3,arr)+ fib(2,arr); 2+ 1 = 3
            //arr[3] = fib(2,arr)+ fib(1,arr);//1+ 1 = 2
            //arr[2] //1
        }
        return arr[n];
    }

    //non recursion
    public static int fib3(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = arr[2] = 1;
        for (int i = 3; i <= n ; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }


    /**
     *滚动数组:
     *3 % 2 = 1 0b011 & 0b001 = 001
     *4 % 2 = 0 0b100 & 0b001 = 000
     *5 % 2 = 1 0b101 & 0b001 = 001
     *6 % 2 = 0 0b110 & 0b001 = 000
     */
    public static int fib4(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];
        arr[0] = arr[1] = 1;
        for (int i = 3; i <= n ; i++){
            arr[i % 2] = arr[(i - 1) % 2] + arr[(i - 2)% 2];
        }
        return arr[n % 2];
    }


    //%2, %运算 ---> &1, &运算
    public static int fib5(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];
        arr[0] = arr[1] = 1;
        for (int i = 3; i <= n ; i++){
            arr[i & 1] = arr[(i - 1) & 1] + arr[(i - 2) & 1];
        }
        return arr[n & 1];
    }

    //双指针
    public static int fib6(int n) {
        //fib(n) = fib(n-1) + fib(n-2)
        if (n <= 1) return n;

        int first = 0;
        int second = 1;
        for (int i = 0; i< n - 1; i++){//n-1为求和的次数
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }



    //tail recursion
    public int fib7(int n) {
        if(n == 0) return 0;
        return fib(n, 0, 1);
    }

    private int fib(int n, int first, int second){
        if (n <= 1) return second ;
        return fib(n - 1, second, first + second);
    }

}
