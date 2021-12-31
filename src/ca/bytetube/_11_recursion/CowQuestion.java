package ca.bytetube._11_recursion;

public class CowQuestion {

    public static void main(String[] args) {
        System.out.println(cowQuestion4(7));
    }
    public static int cowQuestion1 (int n){
        if (n < 1) return 0;
        if (n <= 4) return n;

        return cowQuestion1(n - 1) + cowQuestion1(n - 3);//down to top
    }

    public static int cowQuestion2(int n){
        if (n < 1) return 0;
        int[] arr = new int[n + 1];
        return cowQuestion2(n,arr);
    }

    private static int cowQuestion2(int n, int[] arr) {
        if (n <= 4) {
            arr[n] = n;
        }else {
            arr[n] = cowQuestion2(n - 1, arr) + cowQuestion2(n - 3, arr);
        }
        return arr[n];
    }

    public static int cowQuestion3(int n){
        if (n < 1) return 0;
        int[] arr = new int[n + 1];
        for (int i = 1; i < 5 ; i++) {
            arr[i] = i;
        }
        for (int i = 5; i < n + 1 ; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
        }
        return arr[n];
    }

    public static int cowQuestion4(int n) {
        if (n < 1) return 0;
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1 ; i++) {
            if (i <= 4) {
                arr[i] = i;
            }else {
                arr[i] = arr[i - 1] + arr[i - 3];
            }
        }
        return arr[n];
    }
}
