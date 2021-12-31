package ca.bytetube._15_dp;

public class LongestIncreasingSubsequence {
    public int longestOfLIS (int[] nums){
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        int max = dp[0] = 1;

        for (int i = 1; i < dp.length ; i++) {
            dp[i] = 1;//！   每个初始值为1
            for (int j = 0; j < i; j++) {
                //1.if nums[i] <= nums[j]
                if (nums[i] <= nums[j]) continue;
                //2. if nums[i] > nums[j]
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
