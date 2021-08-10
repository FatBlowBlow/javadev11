package ca.bytetube._13_greedy;

import java.util.Arrays;

public class Pirate {
    public static void main(String[] args) {
        countGoods(30, new int[]{3, 5, 4, 10, 7, 14, 2, 11});
    }


    public static int countGoods(int capacity, int[] weights){
        if (weights == null || weights.length == 0) return 0;
        Arrays.sort(weights);
        int count = 0;
        int weight = 0;
        for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weight + weights[i];
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
            }
        }

        return 0;
    }
}
