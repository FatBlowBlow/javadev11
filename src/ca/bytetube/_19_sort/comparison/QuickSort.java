package ca.bytetube._19_sort.comparison;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,3,5,8,6,7,4,5};
        printArray(arr);
        System.out.println("================");
        sort(arr);
        printArray(arr);
    }


    public static void sort(int[] arr){
        quickSort(arr, 0 , arr.length - 1);
    }

    private static void quickSort (int[] arr, int l , int r){
        if (l < r){//不能写while --> if不满足的话直接退出,while不满足的话会一直等着
            int[] partition = partition(arr, l, r);
            quickSort(arr, l, partition[0] - 1);
            quickSort(arr, partition[1] + 1, r);
        }
    }

    //返回值是相等区域的左右边界，[2]
    private static int[] partition(int[] arr, int l, int r){
        int less = l - 1;//起点的前一个位置, l相当于i，起点
        int more = r;
        while (l < more){
            if (arr[l] < arr[r]) {
                swap(arr, ++ less, l++);

            }else if (arr[l] > arr[r]) {
                swap(arr, -- more, l);
            }else{
                l++;
            }
        }
        swap(arr, more, r);//让大于区域的第一个值和本次划分的标准arr[r]交换
        return new int[]{less + 1, more};//存的是划分后的index
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
