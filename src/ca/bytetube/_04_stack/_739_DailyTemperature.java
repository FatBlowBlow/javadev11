package ca.bytetube._04_stack;

import java.util.Stack;

public class _739_DailyTemperature {

    //单调栈 Monotonic Stack
    public int[] dailyTemperatures(int[] temperatures){
        if (temperatures == null || temperatures.length ==0) return null;
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);//只记录index
        }
        return res;
    }
}
