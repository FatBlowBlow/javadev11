package ca.bytetube.day04;

/**
 * for for
 * 5 * 8 matrix
 */
public class Demo06 {
    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 9; j++) {
                System.out.print("x" + " ");
            }
            System.out.println();
        }

        System.out.println("------------------");

        for (int i = 0; i < 5; i++) {
            for (int j = -1; j < i; j++) {
                System.out.print("x" + " ");
            }
            System.out.println();
        }

        System.out.println("------------------");

        for (int i = 0; i < 5; i++) {
            for (int j = 4; j >= 0; j--) {
                if (j > i) System.out.print(" " + " ");
                else System.out.print("x" + " ");
            }
            System.out.println();
        }


    }





}
