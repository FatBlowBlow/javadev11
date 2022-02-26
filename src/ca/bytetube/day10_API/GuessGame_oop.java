package ca.bytetube.day10_API;

import java.util.Random;
import java.util.Scanner;

public class GuessGame_oop {

    private int getRanNum(int bound){
        Random random = new Random();
        return random.nextInt(bound) + 1;
    }

    private int getGuessNum(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please put your data: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        GuessGame_oop game = new GuessGame_oop();
        int n = 100;
        int ranNum = game.getRanNum(n);
        System.out.println(ranNum);
        int guessNum = game.getGuessNum();
        //3.比较随机数和用户输入数
        while (guessNum != ranNum) {
            if (guessNum < ranNum) {
                System.out.println("lesser");
                guessNum = game.getGuessNum();
            }else if (guessNum > ranNum){
                System.out.println("larger");
                guessNum = game.getGuessNum();
            }
        }
        System.out.println("Congratulation, you win!");
    }
}
