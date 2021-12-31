package ca.bytetube._13_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LessMoney {
    public static void main(String[] args) {
        System.out.println(lessMoney(new int[]{10, 20, 30, 40, 50}));
    }

    public static int lessMoney(int[] arr){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        int res = 0;
        while (priorityQueue.size() > 1){
           int cur = priorityQueue.poll() + priorityQueue.poll();
           res += cur;
           priorityQueue.add(cur);
        }

        return res;
    }
}
