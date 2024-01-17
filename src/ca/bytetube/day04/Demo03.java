package ca.bytetube.day04;

/**
 * while loop
 */
public class Demo03 {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while (i < 101){
            if (i % 2 == 0){
                sum += i;
            }
            i++;
        }
        System.out.println(sum);

        int a = 2;
        int res = 0;
        while (a < 101){
            res += a;
            a +=2;
        }
        System.out.println(res);

    }
}
