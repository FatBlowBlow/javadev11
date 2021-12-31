package ca.bytetube._19_sort.comparison;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {7,3,5,8,6,7,4,5};
        printArray(arr);
        sort(arr);
        System.out.println("================");
        printArray(arr);
    }

    public static void sort(int[] arr){
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);

    }


    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) return;
        int mid = (l + r) >> 1;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];//辅助数组，装每一回合中merge后的结果
        int i = 0;//help数组中的index
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r) help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];

        while (p1 <= m) help[i++] = arr[p1++];//p2走完，p1全部往里倒

        while (p2 <= r) help[i++] = arr[p2++];

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];//有一个偏移量l
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
