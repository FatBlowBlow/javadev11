package ca.bytetube._15_dp;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(LongestCommonSubstring3("ABCBA", "BABA"));
    }

    public static int LongestCommonSubstring3 (String str1, String str2){
        char[] chars1 = str1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = str2.toCharArray();
        if (chars2.length == 0) return 0;

        char[] rowNums = chars1, colNums = chars2;
        if (chars1.length < chars2.length) {
            colNums = chars1;
            rowNums = chars2;
        }
        int[] dp = new int[colNums.length + 1];
        int max = 0;
        for (int row = 1; row <= rowNums.length ; row++) {
            for (int col = colNums.length; col >= 1 ; col--) {
                if (chars1[row - 1] != chars2[col - 1]) {
                    dp[col] = 0;
                }else{
                    dp[col] = dp[col - 1] + 1;
                    max = Math.max(dp[col], max);
                }
            }
        }
        return max;
    }

    public static int LongestCommonSubstring2 (String str1, String str2){
        char[] chars1 = str1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = str2.toCharArray();
        if (chars2.length == 0) return 0;

        char[] rowNums = chars1, colNums = chars2;
        if (chars1.length < chars2.length) {
            colNums = chars1;
            rowNums = chars2;
        }
        int[] dp = new int[colNums.length + 1];
        int max = 0;
        for (int row = 1; row <= rowNums.length ; row++) {
            int cur = 0;
            for (int col = 1; col <= colNums.length ; col++) {
                int leftTop = cur;
                cur = dp[col];
                if (chars1[row - 1] != chars2[col - 1]) {
                    dp[col] = 0;
                }else{
                    dp[col] = leftTop + 1;
                    max = Math.max(dp[col], max);
                }
            }
        }
        return max;
    }

    public static int LongestCommonSubstring1 (String str1, String str2){
        char[] chars1 = str1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = str2.toCharArray();
        if (chars2.length == 0) return 0;

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = 0;
        for (int i = 1; i <= chars1.length ; i++) {
            for (int j = 1; j <= chars2.length ; j++) {
//                if(chars1[i - 1] == chars2[j - 1] ){
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                }else {
//                    dp[i][j] = 0;//dp[][] default value == 0
//                }
                if(chars1[i - 1] != chars2[j - 1] )continue;
                dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

}
