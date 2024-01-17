package ca.bytetube.day03;

import java.util.Scanner;

//switch
public class Demo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input the date:");
        String date = scanner.next().toUpperCase();

        switch (date){
            case "MON":
                System.out.println("running");
                break;
            case "WED":
                System.out.println("reading");
                break;
            case "FRI":
                System.out.println("playing");
                break;
            default:
                System.out.println("sleeping");
                break;
        }
    }
}
