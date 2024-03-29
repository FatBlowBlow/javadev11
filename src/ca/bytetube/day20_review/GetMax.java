package ca.bytetube.day20_review;

import java.util.Arrays;

public class GetMax {

    public static void main(String[] args) throws Exception {
        int[] arr = {-1,-2,-56,89,-120};
        System.out.println(getMaxBySort(arr));
    }

    public static int getMax(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) throw new Exception("arr is null or arr is empty");
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }


    public static int getMaxBySort(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) throw new Exception("arr is null or arr is empty");
        Arrays.sort(arr);//升序排
        return arr[arr.length - 1];

    }
}
