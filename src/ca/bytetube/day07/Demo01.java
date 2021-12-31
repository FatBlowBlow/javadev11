package ca.bytetube.day07;

/**
 * Matrix 的第一种格式
 */


public class Demo01 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];//m=3 行数（有几个一维数组）；n=4,列数（每个一维数组有几个元素）
        System.out.println(matrix);
        System.out.println(matrix[0]);//第一行数组
        System.out.println(matrix[1]);//第二行数组
        System.out.println(matrix[2]);//第三行数组
        System.out.println(matrix[0][1]);//第一行数组的第二个数字，index都是从0开始的
    }
}
