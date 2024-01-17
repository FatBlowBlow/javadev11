package ca.bytetube._15_dp;

/**
 * dp[n] is the minimum number of coins needed to get n cents --->  get n cents的最少的零钱数
 */

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange1(41));
    }

    public static int coinChange4(int[] coins, int amount){
        if (amount < 1 || coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];//dp数据表把数据进行记录
        for (int i = 1; i <= amount; i++) {
            //整体逻辑：dp[i]= min {dp(i - 25), dp(i - 20),dp(i - 5),dp(i - 1)} + 1
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin || dp[i - coin] == -1) continue;
                min = Math.min(dp[i - coin], min);
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;//没有硬币可找， leetcode要求为-1
            }else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }


    /**
     *Iteration (bottom up)
     *由记忆化搜索知道，要算出较大的amount所对应的硬币数，需要先算出较小的amount所对应的硬币数
     * Iteration： 先算出较小的amount所对应的硬币数，再依次得到较大的amount所对应的硬币数
     */

    public static int coinChange3(int amount){
        if (amount < 1) return -1;
        int[] dp = new int[amount + 1];//dp数据表把数据进行记录

        for (int i = 1; i <= amount; i++) {
            //整体逻辑：dp[i]= min {dp(i - 25), dp(i - 20),dp(i - 5),dp(i - 1)} + 1
            int min = dp[i - 1];
//            int min = Integer.MAX_VALUE;
//            if (i >= 1) min = Math.min(dp[i - 1], min);
            if (i >= 5) min = Math.min(dp[i - 5], min);
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);
            dp[i] = min + 1;
        }
        return dp[amount];
    }


    /**
     *top --> down, Memorized
     */
    public static int coinChange2(int amount){
        if (amount < 1) return -1;
        int[] dp = new int[amount + 1];//dp数据表把数据进行记录
        int[] coins = {1, 5, 20, 25};
//         dp[1] = dp[5] = dp[20] = dp[25] = 1;
        for (int coin :coins) {
            if (amount < coin) break;
            dp[coin] = 1;
        }
        return coinChange2(amount, dp);
    }

    /**
     * 当找零钱为amount时，需要返回的硬币个数
     */
    private static int coinChange2(int amount, int[] dp) {
        if (amount < 1) return Integer.MAX_VALUE;

        if (dp[amount] == 0) {
            int min1 = Math.min(coinChange2(amount - 25, dp), coinChange2(amount - 20, dp));
            int min2 = Math.min(coinChange2 (amount - 5,dp), coinChange2(amount - 1,dp));
            dp[amount] = Math.min(min1, min2) + 1;
        }

        return dp[amount];

    }


    /**
     * top --> down, recursion
     */
    public static int coinChange1(int n){

        if (n <= 1) return Integer.MAX_VALUE;

        if (n == 25 || n == 20 || n == 5 || n == 1 ) return 1;


        int min1 = Math.min(coinChange1(n - 25), coinChange1(n - 20));
        int min2 = Math.min(coinChange1(n - 5), coinChange1(n - 1));
        return Math.min(min1, min2) + 1;

    }
}
