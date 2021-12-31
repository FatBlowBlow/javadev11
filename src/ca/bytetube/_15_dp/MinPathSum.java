package ca.bytetube._15_dp;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{3, 1, 0, 2}, {4, 3, 2, 1}, {5, 2, 1, 0}};
        System.out.println(minPathSum1(matrix));
    }

    /**
     * leetCode 64: Minimum Path Sum
     * dp
     */
    public static int minPathSum1(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        System.out.println("dp[0][0] :" + dp[0][0]);
        //1.first row
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
            System.out.println("dp[0][" + i + "]:" + dp[0][i]);
        }

        //2.first column
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
            System.out.println("dp[" + i + "][0]" + dp[i][0]);
        }
        //普通位置
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
                System.out.println("dp[" + i + "][" + j + "]" + dp[i][j]);
            }
        }
        return dp[row - 1][col - 1];
    }


    //recursion
    public static int minPathSum(int[][] matrix) {
        return minPathSum(matrix, 0, 0);
    }

    public static int minPathSum(int[][] matrix, int i, int j) {
        //选终点作为起点的时候能一次性给出答案 --> 终点值本身
        if (i == matrix.length - 1 && j == matrix[0].length - 1) return matrix[i][j];

        if (i == matrix.length - 1) {//最后一行
            return matrix[i][j] + minPathSum(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {//最后一列
            return matrix[i][j] + minPathSum(matrix, i + 1, j);
        }

        //普通位置
        int right = minPathSum(matrix, i, j + 1);
        int down = minPathSum(matrix, i + 1, j);
        return matrix[i][j] + Math.min(right, down);
    }
}




