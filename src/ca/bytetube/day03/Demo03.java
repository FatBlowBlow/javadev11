package ca.bytetube.day03;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input what you want:");
        int userInput = scanner.nextInt();
        System.out.println("output:" + userInput);
//        if (userInput % 2 == 0){
//            System.out.println("it's 偶数");
//        }else{
//            System.out.println("it's 奇数");
//        }

        //ternary operator
        String s = userInput % 2 == 0 ? "it's even" : "it's odd";
        System.out.println(s);
    }
}
