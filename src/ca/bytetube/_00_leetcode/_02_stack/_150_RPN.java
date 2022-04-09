package ca.bytetube._00_leetcode._02_stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class _150_RPN {

    //运算符只进行一次判断
    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token){
                case ("+"):
                    stack.push(stack.pop() + stack.pop());
                    break;
                case ("*"):
                    stack.push(stack.pop() * stack.pop());
                    break;
                case ("-"):
                    Integer right = stack.pop();
                    //Integer left = stack.pop();
                    stack.push(stack.pop() - right);
                    break;
                case ("/"):
                    Integer right2 = stack.pop();
                    stack.push(stack.pop() / right2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    /**
     * 1.遇到数字，直接压栈， stack push()
     *
     * 2.遇到符号，进行运算:
     *   第一次弹出的数据（右操作数）
     *   第二次弹出的数据（左操作数）
     *
     * 3.结合当前符号，进行运算
     *   把运算后的结果重新压栈 stack push()
     *
     * 4.stack中的最后一个元素就是整个运算的结果
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            //1.符号
            if(isOperator(token)) stack.push(calculate(stack.pop(), stack.pop(), token));
            //2.数字
            else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        //return token.equals("+") || token.equals("-") || token.equals("*")  || token.equals("/");
        return "+-*/".contains(token);
    }

    private int calculate(Integer right, Integer left, String operator) {
        switch(operator){//跳表结构 skip list, 比if else 高效得多
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            default: return left / right;
        }
    }

}
