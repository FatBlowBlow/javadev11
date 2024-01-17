package ca.bytetube._12_backTracking;

public class NQueens {

    //index：行号， value（数组元素值）：列号
    //cols[4] = 5 -->第四行的第五列上安放了皇后
    int[] cols;

    int ways;//摆法
    public int totalNQueens(int n){
        if (n < 1) return 0;
        cols = new int[n];
        place(0);
        return ways;
    }

    /**
     *从第row行开始摆放皇后
     */
    private void place(int row) {
        if (row == cols.length) {//if row = 8 --> 说明从第0行到第7行都摆好了
            ways++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {//column

            if(isValid(row, col)){//pruning --> 取有效的单元格
                cols[row] = col;//在第row行的第col列安放皇后

                place(row + 1);//该放下一行的了，同时会自动回溯
            }
        }
    }

    /**
     * pruning -->剪枝：判断在第row行的第col列，是否可以摆放皇后
     * 不用考虑row， 只用考虑col和对角线
     */
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {//i < row --> 说明取得的i是前面行的行号
            //列
            if (cols[i] == col) return false;

            //对角线 ---> n*n的棋盘---> 对角线上的点连成的线的斜率|k| =1
//            if (Math.abs(col - cols[i])/(row - i) == 1) --->不能这么写，分母会有特殊情况
            if (Math.abs(col - cols[i]) == (row - i)) return false;
        }
        return true;
    }
}
