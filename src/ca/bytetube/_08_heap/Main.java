package ca.bytetube._08_heap;

import ca.bytetube._08_heap.printer.BinaryTrees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        topK1(new Integer[]{88,44,53,41,6,70,18,85,98,81,23,36,43,37},5);
        //test3();
    }

    private static void test1() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(68);
        heap.add(72);
        heap.add(43);
        heap.add(50);
        heap.add(38);
        heap.add(10);
        heap.add(90);
        heap.add(65);

        BinaryTrees.println(heap);
//        System.out.println("======================================");
//        heap.replace(12);
//        BinaryTrees.println(heap);


    }

    public static void test2(){
        Integer[] data = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
        BinaryTrees.println(heap);
    }

    public static void test3(){
        Integer[] data = {88, 44, 53, 41, 16};
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        },data);
        BinaryTrees.println(heap);
    }

    //前k大的数 ---> miniHeap
    public static void topK(Integer[] data, int k){
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0 ; i < data.length; i++ ){
            if (heap.size < k) {
                heap.add(data[i]);
            }else if (data[i] > heap.get()){
                heap.replace(data[i]);
            }
        }
        BinaryTrees.println(heap);
    }

    //前k小的数 ---> maxHeap
    public static void topK1(Integer[] data, int k){
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        for (int i = 0 ; i < data.length; i++ ){
            if (heap.size < k) {
                heap.add(data[i]);
            }else if (data[i] < heap.get()){
                heap.replace(data[i]);
            }
        }
        BinaryTrees.println(heap);
    }

    //priorityQueue 优先级队列
    public static void test4(){
        Integer[] data = {88, 44, 53, 41, 70};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(Integer d : data){
            priorityQueue.add(d);
        }

        System.out.println(priorityQueue);

    }



}

