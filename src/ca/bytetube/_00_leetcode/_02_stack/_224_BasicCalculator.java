package ca.bytetube._00_leetcode._02_stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 * + - ( ) 运算
 * - 可以用作负数
 */
public class _224_BasicCalculator {

    public static void main(String[] args) {
        String s = "1-(     -2)";
        System.out.println(basicCalculator(s));
    }

    public static int basicCalculator(String s){
        int res = 0, sum = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for(char c : s.toCharArray()){
            if (Character.isDigit(c)) sum = sum * 10 + (c - '0');
            else{
                res += sum * sign * stack.peek();
                sum = 0;
                if (c == '-') sign = -1;
                else if (c == '+') sign = 1;
                else if (c == '('){
                    stack.push(stack.peek() * sign);
                    sign = 1;
                }else if (c == ')') stack.pop();
            }
        }
        res += sign * sum;
        return res ;
    }


}
