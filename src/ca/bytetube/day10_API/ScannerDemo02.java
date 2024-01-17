package ca.bytetube.day10_API;


import java.util.Scanner;

/**
 * 获取用户的输入，并求和
 * 当用户输入-1时，程序停止并求和
 */

public class ScannerDemo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("plz inout your data: ");
//        int data = sc.nextInt();
        int data = 0;
        int sum = 0;
        while(data != -1){
            sum += data;
            System.out.println("plz inout your data: ");
            data = sc.nextInt();
        }
        System.out.println(sum);
    }
}
