package ca.bytetube._19_sort.comparison;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {7,3,5,8,6,7,4,5};
        printArray(arr);
        sort(arr);
        System.out.println("================");
        printArray(arr);
    }


    public static void sort(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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
