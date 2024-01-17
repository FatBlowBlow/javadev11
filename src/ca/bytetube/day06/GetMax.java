package ca.bytetube.day06;

/**
 * get max element from array
 */
public class GetMax {
    public static void main(String[] args) throws Exception {
//        int[] arr = {10, 4, -5, 9, 22, 7};
        int[] arr = getRandomArray(5, 500);
        printArray(arr);
        System.out.println();
        int max = getMax02(arr);
        System.out.print(max);
    }

    private static int getMax(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("array cannot be null and length cannot be 0");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int getMax02(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("array cannot be null and length cannot be 0");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
          max = max > arr[i]? max : arr[i];
        }
        return max;
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
