package ca.bytetube.day03;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println(numSum(10, 98));
    }

    //method ---> function ---> api
    /**
     * two nums sum
     * num1, num2 (int)
     * sum (int)
     */

    public static int numSum (int num1, int num2){
        int sum = num1 + num2;
        return sum;
    }
}
