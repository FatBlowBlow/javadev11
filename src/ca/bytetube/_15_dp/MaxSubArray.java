package ca.bytetube._15_dp;

public class MaxSubArray {
    public static void main(String[] args) {
        maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    /**
     * 优化：
     * 因为只需要看前一个状态，前一个数据 ---> 不用创建数组
     */
    public static int maxSubArray(int[] nums){
        int dp = nums[0];//滚动数组，table view
        int max = dp;
        System.out.println("dp[0] = " + dp);
        for (int i = 1; i < nums.length ; i++) {//i是下标
            //1. if dp[i - 1] <=0, dp[i] = nums[i]
            if (dp <= 0) {
                dp = nums[i];
            }else {//2.if dp[i - 1] > 0, dp[i] = dp[i - 1] + nums[i]
                dp += nums[i];
            }
            max = Math.max(dp, max);
            System.out.println("dp[" + i + "] =" + dp);
        }
        return max;
    }

    public static int maxSubArray1(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        System.out.println("dp[0] = " + dp[0]);
        for (int i = 1; i < dp.length ; i++) {//i是下标
            //1. if dp[i - 1] <=0, dp[i] = nums[i]
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            }else {//2.if dp[i - 1] > 0, dp[i] = dp[i - 1] + nums[i]
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(dp[i], max);
            System.out.println("dp[" + i + "] =" + dp[i]);
        }
        return max;
    }
}
