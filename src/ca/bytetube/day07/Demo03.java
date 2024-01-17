package ca.bytetube.day07;

public class Demo03 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for (int i = 0; i < matrix.length; i++) {//控制行数，有多少个一维数组
            for (int j = 0; j < matrix[i].length; j++) {//所在行的
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
