package ca.bytetube._15_dp;

public class IsAimInSumOfArray {

    public static void main(String[] args) {
        System.out.println(isAimInSumOfArray1(new int[]{3,4,7,13}, 20));
    }

    public static boolean isAimInSumOfArray2(int[] arr, int aim){
        //>aim的不用, default value: false
        boolean[][] dp = new boolean[arr.length][aim + 1];
        for (int i = 0; i < dp.length ; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0 ; j--) {
//                if (dp[i + 1][j] == true) {
//                    dp[i][j] = true;
//                }
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
            }
        }
        return dp[0][0];
    }



    public static boolean isAimInSumOfArray1(int[] arr, int aim){
        return isAimInSumOfArray(arr, 0, 0, aim);
    }

    public static boolean isAimInSumOfArray(int[] arr, int i, int sum, int aim){
        if (sum == aim) return true;
        if (i == arr.length) return false;
        return isAimInSumOfArray(arr, i + 1, sum + arr[i], aim) ||
                isAimInSumOfArray(arr, i + 1, sum, aim);
    }
}
