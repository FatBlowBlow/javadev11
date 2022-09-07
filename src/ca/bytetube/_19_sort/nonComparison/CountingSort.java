package ca.bytetube._19_sort.nonComparison;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {7,3,5,8,6,7,4,5};
        printArray(arr);
        sort(arr);

        printArray(arr);

    }

    public static void sort(int[] array){//优化后版本
        //1.找到原数组中的最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)  max = array[i];
            if (array[i] < min)  min = array[i];
        }

        //2.创建table，用于储存元素累加出现的次数
        int[] counts = new int[max - min + 1];//优化空间

        //第一个counts表, 记录每个数出现的frequency
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;//array[i] - min, counts index: k-min
        }

        //最终的counts表, 从第二个数开始累加
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        //不能省略，因为如果使用之前的array接收结果会出现数据错乱
        int[] sortedArray = new int[array.length];
        //从右向左对initial array进行遍历，目的是为了保证排序的稳定性
        for (int i = array.length - 1; i >= 0; i--) {
//            int index = counts[array[i] - min]--;
//            sortedArray[index] = array[i];
            sortedArray[--counts[array[i] - min]] = array[i];
        }

        for (int i = 0; i < sortedArray.length ; i++) {
            array[i] = sortedArray[i];
        }
    }

    public static void sort1(int[] array){//只能排非负整数
        //1.找到原数组中的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)  max = array[i];
        }

        //2.创建table，用于储存元素出现的次数
        int[] counts = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        //3.根据table元素出现的次数，对原数组进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        }

    }

    public static void printArray(int[] arr){
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
