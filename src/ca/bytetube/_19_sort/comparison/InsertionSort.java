package ca.bytetube._19_sort.comparison;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7,3,5,8,6,7,4,5};
        printArray(arr);
        sort(arr);
        System.out.println("================");
        printArray(arr);
    }


    public static void sort(int[] arr){
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }



    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr){
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
