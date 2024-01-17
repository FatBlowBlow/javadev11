package ca.bytetube._00_leetcode._0_array;

public class _88_MergeSortedArray {
    public static void main(String[] args) {

    }

    public static void merge (int[] nums1, int m, int[] nums2, int n){
        int l1 = m - 1;
        int l2 = n - 1;
        int cur = nums1.length - 1;
        //把nums2 merge到nums1中
        while (l2 >= 0){
            if (l1 > 0 && nums1[l1] > nums2[l2]) {
                nums1[l1--] = nums1[cur--];
            }else{//l1 < 0 || nums1[l1] < nums2[l2]
                nums2[l2--] = nums1[cur--];
            }
        }
    }
}
