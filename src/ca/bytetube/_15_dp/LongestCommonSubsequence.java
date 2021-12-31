package ca.bytetube._15_dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence(new int[]{1, 3, 5, 9, 10}, new int[]{1, 4, 9, 10}));
    }

    // 一维数组 ---> 长度再次优化
    public static int longestCommonSubsequence (int[] nums1, int[] nums2) {
        int[] rowNums = nums1, colNums = nums2;
        if (nums1.length < colNums.length) {
            colNums = nums1;
            rowNums = nums2;
        }
        int[] dp = new int[colNums.length + 1];
        for (int row = 1; row <= rowNums.length ; row++) {
            int cur = 0;
            for (int col = 1;col <= colNums.length ; col++ ){

                int leftTop = cur;
                cur = dp[col];

                if (rowNums[row - 1] == colNums[col - 1]){
                    dp[col] = leftTop + 1;
                }else {

                    dp[col] = Math.max(dp[col], dp[col - 1]);
                }
            }
        }
        return dp[colNums.length];
    }



    //优化 ---> 一维数组
    public static int longestCommonSubsequence4 (int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length ; i++) {
            int cur = 0;//算（1，1）时， 左上角(0,0)位为0
            for (int j = 1;j <= nums2.length ; j++ ){

                int leftTop = cur;
                cur = dp[j];//算新的dp[j]之前，需要先保存原来的dp[j]的值

                if (nums1[i - 1] == nums2[j - 1]){
                    dp[j] = leftTop + 1;
                }else {
                    //dp[j]:top,  dp[j - 1]:left
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[nums2.length];
    }


    //dp 优化 ---> 行数固定为2 ---> 滚动数组
    public static  int longestCommonSubsequence3 (int[] nums1, int[] nums2) {
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 1; i <= nums1.length ; i++) {

            int row = i % 2;// 位运算：i & 1
            int preRow = (i - 1) % 2; // 位运算：(i - 1) & 1

            for (int j = 1;j <= nums2.length ; j++ ){
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[row][j] = dp[preRow][j - 1] + 1;
                }else {
                    dp[row][j] = Math.max(dp[preRow][j], dp[row][j - 1]);
                }
            }
        }
        return dp[nums1.length % 2][nums2.length];
    }


    //dp 二维
    public static int longestCommonSubsequence2 (int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];//default is 0
        for (int i = 1; i <= nums1.length ; i++) {
            for (int j = 1;j <= nums2.length ; j++ ){
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }


    //recursion
    public static int longestCommonSubsequence1 (int[] nums1, int[] nums2) {//需要动态的变--->马甲函数
        return longestCommonSubsequence(nums1, nums1.length, nums2, nums2.length);
    }

    public static int longestCommonSubsequence (int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) return 0;//递归基--->递归结束的条件
        if (nums1[i - 1] == nums2[j - 1]){
            return longestCommonSubsequence(nums1, i - 1, nums2, j - 1) + 1;
        }

        return Math.max(longestCommonSubsequence(nums1, i - 1, nums2, j),
                longestCommonSubsequence(nums1, i , nums2, j - 1));
    }
}
