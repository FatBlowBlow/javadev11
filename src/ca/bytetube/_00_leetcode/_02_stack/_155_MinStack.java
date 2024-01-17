package ca.bytetube._00_leetcode._02_stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 */
public class _155_MinStack {

//    Stack<Integer> stackData;
//    Stack<Integer> stackMin;
//
//
//    public _155_MinStack() {//初始化
//        stackData = new Stack<>();
//        stackMin = new Stack<>();
//    }
//
//    public void push(int val) {
//        stackData.push(val);
//        if (stackMin.isEmpty()) stackMin.push(val);
//        else if (val <= stackMin.peek()) stackMin.push(val);
//    }
//
//    public void pop() {
//        int val = 0;
//        if (!stackData.isEmpty()) val = stackData.pop();
//        if (val == stackMin.peek()) stackMin.pop();
//    }
//
//    public int top() {
//        return stackData.peek();
//    }
//
//    public int getMin() {
//        if (stackMin.isEmpty()) throw new RuntimeException();
//        return stackMin.peek();
//    }


    Node head;//链表的头节点
    private static class Node{
        int val;
        Node next;
        int min;//当前链表的最小值

        public Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    public _155_MinStack() {//初始化
       //dummy node 虚拟头节点,无意义,形式占位
        head = new Node(0, null, Integer.MAX_VALUE);
    }

    public void push(int val) {
      head = new Node(val, head, Math.min(val, head.min));//头插
    }

    public void pop() {
        head = head.next;//把之前的节点忽略
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

}
