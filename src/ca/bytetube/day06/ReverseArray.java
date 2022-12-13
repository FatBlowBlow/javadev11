package ca.bytetube.day06;

import java.util.Arrays;

/**
 * reverse an array
 */

public class ReverseArray {
    public static void main(String[] args) throws Exception {
        int[] arr = getRandomArray(5, 500);
        printArray(arr);
        System.out.println();
        int[] reversedArr = reverseArr02(arr);
        printArray(reversedArr);

    }

    //创建个新数组
    public static int[] reverseArr(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("array cannot be null and length cannot be 0");
        }
        int[] reversedArr = new int[arr.length];
        int cur = 0;
        for (int i = arr.length - 1; i >= 0  ; i--) {
            reversedArr[cur] = arr[i];
            cur++;
        }
        return reversedArr;
    }

    //双指针
    public static int[] reverseArr02(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("array cannot be null and length cannot be 0");
        }
        int front = 0;
        int rear = arr.length - 1;
        while (front < rear) {
            swap(arr, front, rear);
            front++;
            rear--;
        }
        return arr;
    }

    public static void swap(int[] arr, int num1, int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }



    public static int[] getRandomArray(int size, int bound){
        int[] ranArray = new int[size];
        for (int i = 0; i < ranArray.length ; i++) {
            int ranNum = (int) (Math.random() * bound);
            ranArray[i] = ranNum;
        }
        return ranArray;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
