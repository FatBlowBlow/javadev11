package ca.bytetube._00_leetcode._0_array;

import java.util.*;


/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class _287_FindDuplicate {

    //set(without modifying input), time: O(n) & space: O(n)
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return nums[i];
        }
        return Integer.MIN_VALUE;
    }

    //count(without modifying input), time: O(n) & space: O(n)
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] > 1) return nums[i];
        }
        return Integer.MIN_VALUE;
    }

    //visited(modifying input), time: O(n) & space: O(1)
    public int findDuplicate3(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index] < 0) return index;
            nums[index] = - nums[index];
        }
        return Integer.MIN_VALUE;
    }

    //sort(modifying input), time: O(nlogn) & space: O(logn)
    public int findDuplicate4(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return Integer.MIN_VALUE;
    }


    public static void main(String[] args) {
        int[] arr = {10, 99, 109, 7, 45, 86, 23, 99, 45};
//        System.out.println(duplicateNum3(arr));
//        duplicateNum(arr);
        Integer[] intArray = duplicateNum3(arr);
        for (int i : intArray) {
            System.out.println(i);
        }
    }

    private static void duplicateNum(int[] arr) {
        if (arr == null || arr.length == 0) return;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) System.out.println(arr[i]);
        }
    }

    private static String duplicateNum2(int[] arr) {
        if (arr == null || arr.length == 0) return null ;
        Set<Integer> set = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) sb.append(arr[i] + " ");
        }
        return sb.toString();
    }

    private static Integer[] duplicateNum3(int[] arr) {
        if (arr == null || arr.length == 0) return null ;
        Set<Integer> set = new HashSet();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) list.add(arr[i]);
        }
        Integer[] intArr = list.toArray(new Integer[list.size()]);
        return intArr;
    }
}
