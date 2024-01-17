package ca.bytetube._16_window;

import java.util.Deque;
import java.util.LinkedList;

public class GetNumOfSubArray {

    public static void main (String[] args) {
        int[] arr = {5,6,7};
        System.out.println(getNumOfSubArray(arr, 2));
    }



    public static int getNumOfSubArray(int[] arr, int num){
        Deque<Integer> qMin = new LinkedList<>();
        Deque<Integer> qMax = new LinkedList<>();
        int L = 0, R = 0, res = 0;
        //L固定，R向右不断扩，直到不能扩的时候停
        while (L < arr.length){
            while (R < arr.length){
                //更新最小值L的结构
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R]){
                    qMin.pollLast();
                }
                qMin.addLast(R);
                //更新最大值R的结构
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]){
                    qMax.pollLast();
                }
                qMax.addLast(R);
                //不达标
                //arr[x] - arr[L] > num
                if (arr[qMax.getFirst()] - arr[qMin.getFirst()]  > num) break;
                R++;
            }

            //判断最小值的结构下标是否过期
            if (qMin.peekFirst() == L) qMin.pollFirst();
            //判断最大值的结构下标是否过期
            if (qMax.peekFirst() == L) qMax.pollFirst();

            res += R - L;

            L++;
        }
        return res;
    }
}
