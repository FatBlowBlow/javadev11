package ca.bytetube._00_leetcode._03_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class _225_ImplementStackUsingQueues {

    private Queue<Integer> data;
    private Queue<Integer> help;

    public _225_ImplementStackUsingQueues(){
        this.data = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public void push(int val){
        data.offer(val);
    }

    public int pop(){
        //1.依次弹出data queue中前n-1个元素并装入help queue中
        while (data.size() > 1){//留最后一个元素
            help.offer(data.poll());
        }
        //2.弹出最后一个元素
        int pop = data.poll();
        //3.交换help和data的引用
        swap();
        return pop;
    }

    public int peek(){
        //1.依次弹出data queue中前n-1个元素并装入help queue中
        while (data.size() > 1){
            help.offer(data.poll());
        }
        //2.弹出最后一个元素
        int peek = data.poll();
        //2.1需要把弹出的最后一个元素再次装回help queue中
        help.offer(peek);
        //3.引用交换
        swap();
        return peek;
    }

    public boolean empty() {
        return data.isEmpty();
    }

    private void swap(){
        Queue<Integer> temp = help;
        help = data;
        data = temp;
    }
}
