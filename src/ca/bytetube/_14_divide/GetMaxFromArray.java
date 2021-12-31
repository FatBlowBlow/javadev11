package ca.bytetube._14_divide;

public class GetMaxFromArray {

    public static int getMaxFromArray(int[] arr){

        return getMaxFromArray(arr, 0, arr.length - 1);
    }

    public static int getMaxFromArray (int[] arr, int left, int right){
        if (left == right) return arr[left];
        int mid = (left + right)/2;
        int leftMax = getMaxFromArray(arr, left, mid);
        int rightMax = getMaxFromArray(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,8,9,2,6,1};
        System.out.println(getMaxFromArray(arr));

    }
}
