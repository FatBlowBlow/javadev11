package ca.bytetube.day10_API;

import java.util.Random;

public class RandomDemo01 {
    public static void main(String[] args) {
        Random random = new Random();
        int ranNum = random.nextInt(100);//左闭右开 [0,100)

    }
}
