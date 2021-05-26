package ca.bytetube.leetcode.array;

public class Partition {

    public static void partition (int[] array, int pivot){
        if (array == null || array.length < 2) return;//如果代码中，语句块的逻辑体很少，大括号可以不写，精简代码

        partition(array, 0, array.length - 1, pivot);

    }


    //overload：方法重载，名称相同，参数列表不同
    public static void partition (int[] array, int l, int r, int pivot){
        int less = l - 1;
        int more = r + 1;
//      int cur = l;//可以直接用l代替cur
        while (l < more){//循环结束时：cur=pivot
            if (array[l] < pivot) {
                swap(array, ++less, l++);

            }else if (array[l] > pivot){
                swap(array, --more, l);

            }else {
                l++;
            }

        }

    }

    public static int[] getRandArray(int size, int bound){
        int[] randArray = new int[size];
        for (int i = 0; i < randArray.length; i++) {
//            int randNum1 = (int) (Math.random() * bound);
//            int randNum2 = (int) (Math.random() * bound);
//            int randNum = randNum1 - randNum2;
            int randNum = (int) (Math.random() * bound) - (int) (Math.random() * bound);
            randArray[i] = randNum;
        }
        return randArray;

    }


    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,34,78,106,55,123,88,49,86};
        printArray(array);
        partition(array, 2,6,55);
        System.out.println();
        printArray(array);


    }
}

