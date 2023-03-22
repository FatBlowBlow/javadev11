package ca.bytetube._00_leetcode._0_array;

import java.util.Arrays;

public class SmallestInterval {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 10, 90, 78, 100};
        System.out.println(smallestInterval(arr));
    }

    public static int smallestInterval(int[] arr){
        if (arr == null || arr.length == 0) throw new RuntimeException("arr is null!");
        Arrays.sort(arr);
        int res = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            res = res > arr[i + 1] - arr[i]? arr[i + 1] - arr[i] : res;
        }
        return res;
    }
}
