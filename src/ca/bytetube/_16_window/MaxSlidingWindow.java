package ca.bytetube._16_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] res = maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int nums : res) {
            System.out.print(nums + " ");
        }
    }

    //windows
    public static int[] maxSlidingWindow2(int[] nums, int k){
        if(nums == null || nums.length == 0 || k < 1) return null;
        if (k == 1) return nums;
        int[] res = new int[nums.length - (k - 1)];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {//i:窗口的终点
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.removeLast();
            }
            //能来到这里,说明队尾的那些index所对应的值<=nums[i]都被删除了
            //add index i into tail of deque
            deque.addLast(i);
            int w = i - k + 1;//w:窗口的起点
            if (w < 0) continue;
            if (deque.peekFirst() < w) {//delete expired index
                deque.removeFirst();
            }
            res[w] = nums[deque.peekFirst()];
        }
        return res;
    }

    //dp --> dp[i]: 以nums[i]为begin,长度为k的数组最大值
    public static int[] maxSlidingWindow1(int[] nums, int k){
        if(nums == null || nums.length == 0 || k < 1) return null;
        if (k == 1) return nums;
        int[] dp = new int[nums.length - (k - 1)];
        for (int i = 0; i < nums.length - k ; i++) {
                int max = nums[0];
                for (int j = 0; j < k; j++) {
                    max = Math.max(max,nums[j]);
                }
                dp[0] = max;
                if (dp[i] < nums[i + k]) {
                    dp[i + 1] = nums[i + k];
                }else {
                    dp[i + 1] = dp[i];
                }
        }
        return dp;
    }


    //brute force
    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums == null || nums.length == 0 || k < 1) return null;
        if (k == 1) return nums;
        int[] res = new int[nums.length - (k - 1)];
        for (int i = 0; i <= nums.length - k ; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            res[i] = max;
        }
       return res;
    }



}
