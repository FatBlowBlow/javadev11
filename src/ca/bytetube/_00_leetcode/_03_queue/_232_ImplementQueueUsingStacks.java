package ca.bytetube._00_leetcode._03_queue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */

public class _232_ImplementQueueUsingStacks {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public _232_ImplementQueueUsingStacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void offer(int val){
        inStack.push(val);
    }

    public int poll(){
        if (inStack.isEmpty() && outStack.isEmpty()) throw new RuntimeException("queue is Empty!");
        else if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
         return outStack.pop();
    }


    public int peek(){
        if (inStack.isEmpty() && outStack.isEmpty()) throw new RuntimeException("queue is Empty!");
        else if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}
