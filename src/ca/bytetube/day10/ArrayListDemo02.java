package ca.bytetube.day10;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListDemo02 {
    public static void main(String[] args) {
//        ArrayList<int> arrayList = new ArrayList<>();
        ArrayList<Integer> arrList = new ArrayList<>(6);
        Random random = new Random();
        for (int i = 0; i < 6 ; i++) {
            int ranNum = random.nextInt(33) + 1;
            arrList.add(ranNum);
        }
        for (int i = 0; i < arrList.size() ; i++) {
            System.out.println(arrList.get(i));
        }

    }
}
