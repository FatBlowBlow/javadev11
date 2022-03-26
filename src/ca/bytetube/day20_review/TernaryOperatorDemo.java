package ca.bytetube.day20_review;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. 获取用户的输入（1，2，3，4，5，6。。。）
 * 2. 根据当前用户的输入给出相应的输出 1～5 --- work hard/ 6～7 happy weekend (TernaryOperator)
 */
public class TernaryOperatorDemo {

    public static void main(String[] args) {
        int data = getUserInput();
        String s = outPut(data);
        System.out.println(s);
    }


    public static int getUserInput(){
        System.out.println("please input your data: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static String outPut(int data){
        String res = data >= 1 && data <= 5 ? "work hard" : data >= 6 && data <=7 ? "happy weekend" : "error data";
        return res;

    }
}
