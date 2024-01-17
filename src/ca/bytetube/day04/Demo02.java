package ca.bytetube.day04;

/**
 * 偶数的求和
 */
public class Demo02 {
    public static void main(String[] args) {
      //100 byetube --> type 100.for
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0){
                sum += i;
            }
        }
        System.out.println(sum);

        int res = 0;
        for (int i = 2; i < 101; i += 2) {
            res += i;
        }
        System.out.println(res);


        int res2 = (2 + 100) * 50 / 2;
        System.out.println(res2);
    }
}
