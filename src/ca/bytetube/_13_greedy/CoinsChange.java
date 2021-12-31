package ca.bytetube._13_greedy;

import java.util.Arrays;

public class CoinsChange {
    public static void main(String[] args) {
        System.out.println(coinsChange(new int[]{1, 25, 5, 10},51));
    }

    /**
     * 从大面值的硬币开始找钱
     * 41=25+10+5+1
     */

    public static int coinsChange(int[] faces, int money) {
//        int[] faces = new int[]{1, 25, 5, 10};
//        int money = 51;
        int coins = 0;
        Arrays.sort(faces);//默认升序排 --->1, 5, 10, 25
        for (int i = faces.length - 1; i >= 0 ; i--) {
            if (money < faces[i]) continue;//找下一个值
            System.out.println(faces[i]);
            money -= faces[i];
            coins++;
            i++;//指针原地踏步
        }

        return coins;

    }


}
