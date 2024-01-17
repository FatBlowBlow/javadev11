package ca.bytetube.day04;

/**
 * break & continue
 */
public class Demo04 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            if (i % 3 == 0) {
                break;//结束离break最近的本层循环
            }
            System.out.print(i);
        }

        System.out.println();

        for (int i = 1; i < 11; i++) {
            if (i % 3 == 0) {
                continue;//结束离continue最近的本次循环
            }
            System.out.print(i);
        }
    }
}
