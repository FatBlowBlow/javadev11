package ca.bytetube._01_complexity;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] arr = {16,-2,56,89,120};
        System.out.println(getMax(arr));;
    }

    public static int getMax(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) throw new Exception("arr is null or arr is empty");
       return getMax(arr, 0, arr.length - 1);

    }

    private static int getMax(int[] arr, int left, int right){
        if (left == right) return arr[left];

        int mid = left + ((right - left) >> 1);
        int leftMax = getMax(arr, left, mid);
        int rightMax = getMax(arr, mid + 1, right);

        return Math.max(leftMax, rightMax);
    }

    /**
     * timeComplexity ---> Big O notation
     * ignore constants, coefficients, low-order function
     * 忽略常数，系数，低阶function
     */
    public static void test1(int n){
        //1
        if (n > 10) {
            System.out.println("n > 10");
        }else if (n >= 5){
            System.out.println("n >= 5");
        }else {
            System.out.println("n < 5");
        }

        //1+4+4+4
        for (int i = 0; i < 4; i++) {
            System.out.println("test1");
        }

        //14 --> O(1)
    }

    public static void test2(int n){
        //1+n+n+n = 3n+1 --> O(n)
        for (int i = 0; i < n; i++) {
            System.out.println("test2");
        }
    }

    public static void test3(int n){
        //1+n+n+n(3n+1) = 3n^2 + 3n + 1 ---> O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("test3");
            }
        }
    }

    public static void test4(int n){
        /**
         * n = 8
         *
         * n = 8/2 = 4
         * n = 4/2 = 2
         * n = 2/2 = 1
         *
         * n = 1/2 = 0.5（int向下取整) = 0
         *
         * 执行次数：
         * log2(8) = 3
         * log2(n)
         *
         * O(log n)
         */
        while ((n = n/2)>0){
            System.out.println("test4");
        }
    }


    public static void test5(int n){
        //1 + 2log2(n) + log2(n)(3n + 1) = 1 + 3log2(n) + 3n*log2(n) ---> O(n*log n)
        for (int i = 0; i < n; i = i * 2) {
            for (int j = 0; j < n; j++) {
                System.out.println("test5");
            }
        }
    }


}
