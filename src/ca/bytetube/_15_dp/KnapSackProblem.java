package ca.bytetube._15_dp;

public class KnapSackProblem {

    public static void main(String[] args) {
        int[] weights = {35,30,60,50,40,10,25};
        int[] values = {10,40,30,50,35,40,30};
        System.out.println(maxValue(values, weights, 150));
    }

    public static int maxValue2(int[] values, int[] weights, int capacity){
        if(values == null || values.length == 0) return 0;
        if(weights == null || weights.length == 0) return 0;

        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity];
    }


    public static int maxValue1(int[] values, int[] weights, int capacity){
        if(values == null || values.length == 0) return 0;
        if(weights == null || weights.length == 0) return 0;

        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= 1 ; j--) {
                if (j < weights[i - 1]) continue;
                else dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity];
    }

    public static int maxValue(int[] values, int[] weights, int capacity){
        if(values == null || values.length == 0) return 0;
        if(weights == null || weights.length == 0) return 0;

        int[][] dp = new int[values.length + 1][capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity ; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[values.length][capacity];
    }
}
