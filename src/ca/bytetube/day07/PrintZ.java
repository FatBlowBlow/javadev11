package ca.bytetube.day07;

public class PrintZ {
    public static void printZ(int[][] matrix){
        //a, b,(x, y)
        //init a, b.  R:Roll, C:Column
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;

        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;

        boolean fromUp = false;//一开始是从下开始的 down-->top, (只有两个状态下， 用boolean， 内存小, 2bytes)
        while (aR != endR + 1){//a != b
            printDiagonal(matrix,aR,aC,bR,bC,fromUp);//打对角线

            //打完对角线后，需要对a，b的位置做判断--> a需不需下移？ b需不需要右移？
            //只要a没有走到最后一列，a的行号不变，当走到最后一列时，a的行号加1
            aR = aC == endC? aR + 1 : aR;

            //只要a没有走到最后一列，a的列号加1，当走到最后一列时，a的列号不变
            aC = aC == endC? aC : aC + 1;

            //只要b没有走到最后一行，b的列号不变，当走到最后一行时，a的列号加1
            bC = bR == endR? bC + 1 : bC;

            //只要b没有走到最后一行，b的行号加1，当走到最后一行时，b的行号不变
            bR = bR == endR? bR : bR + 1;

            fromUp = !fromUp;

        }

    }

    private static void printDiagonal(int[][] matrix, int tR, int tC, int dR, int dC, boolean fromUp) {
        if (fromUp == false) {//down --> top
            while(dR != tR - 1) {
                System.out.print(matrix[dR--][dC++] + " ");
            }
        }else {//fromUp = true, top-->down
            while(tR != dR + 1) {
                System.out.print(matrix[tR++][tC--] + " ");
            }
        }

//        if (fromUp == true) {//top --> down
//            while (tR != dR + 1) {
//                System.out.print(matrix[tR++][tC--] + " ");
//            }
//
//        } else {//down --> top，fromUp == false
//            while (dR != tR - 1) {
//                System.out.print(matrix[dR--][dC++] + " ");
//            }
//        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printZ (matrix);

    }

}
