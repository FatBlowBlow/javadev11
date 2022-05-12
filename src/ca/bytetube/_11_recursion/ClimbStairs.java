package ca.bytetube._11_recursion;

public class ClimbStairs {
    public static int climbStairs(int n){
        if (n <= 2) return n;

//        int one = 1;
//        int two = 2;
//        for (int i = 0; i < n - 1; i++){
//            int sum = one + two;
//            one = two;
//            two = sum;
//        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
