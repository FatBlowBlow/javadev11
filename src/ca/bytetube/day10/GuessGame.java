package ca.bytetube.day10;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    private static int getRanNum(int bound){
        Random random = new Random();
        return random.nextInt(bound) + 1;
    }

    private static int getGuessNum(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please put your data: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        //1.产生随机数
//        Random random = new Random();
//        int ranNum = random.nextInt(100) + 1;//[0,100)+1 -->[1,101) -->[1,100]
        int n = 100;
        int ranNum = getRanNum(n);
        System.out.println(ranNum);
        //2.获取用户输入数
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("please put your data: ");
        int guessNum = getGuessNum();
        //3.比较随机数和用户输入数
        while (guessNum != ranNum) {
            if (guessNum < ranNum) {
                System.out.println("lesser");
                guessNum = getGuessNum();
            }else if (guessNum > ranNum) {
                System.out.println("larger");
                guessNum = getGuessNum();
            }
        }
        System.out.println("Congratulation, you win!");
    }

}
