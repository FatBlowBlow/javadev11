package ca.bytetube._01_complexity;

/**
 * fib(n) = fib(n-1) + fib(n-2)
 */
public class _509_FibonacciNumber {
    public static void main(String[] args) throws Exception{
        Times.test("fib", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib(30));
            }
        });


        Times.test("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(30));
            }
        });

    }


    public static int fib(int n){
        if (n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }

    public static int fib2(int n){

        if (n <= 1) return n;
        int first = 0;
        int second = 1;

        for (int i = 0; i < n - 1; i++) {//n-1为求和的次数
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }









}
