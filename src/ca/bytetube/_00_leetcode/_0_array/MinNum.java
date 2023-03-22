package ca.bytetube._00_leetcode._0_array;

import java.util.Arrays;

public class MinNum {
    public static void main(String[] args) {
        int[] arr = {10, 99, 109, 7, 45, 86, 23 };
        System.out.println(minNum2(arr));
    }

    private static int minNum(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("arr cannot be null or empty");
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) min = min > arr[i]? arr[i] : min;
        return min;
    }

    private static int minNum2(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("arr cannot be null or empty");
        Arrays.sort(arr);
        return arr[0];
    }
}
