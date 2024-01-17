package ca.bytetube._00_leetcode._02_stack;

import java.util.Stack;

/**
 * 加减乘除运算，有小括号先算小括号里边的
 * 从左到右计算，先乘除后加减
 */
public class ArithmeticMath {
    public static void main(String[] args){
        String s = "1*3-(1+4/2)";
//        System.out.println("value :" + s);
//        System.out.println("value :" + s.trim());//删除头尾空白符的字符串.
        System.out.println(arithmeticMath(s));

    }

    public static int arithmeticMath(String str){
        Stack<Integer> numstack = new Stack<>();
        Stack<Character> operstack = new Stack<>();
        char[] chars = str.toCharArray();

        for (char c : chars){
            if (isOperator(c)){
                if (!operstack.isEmpty() && operstack.peek() != '(') {
                    if (c == '+' || c == '-') numstack.push(calculate(numstack, operstack));
                }
                operstack.push(c);
            }else if ('(' == c) {
                operstack.push(c);
            }else if (')' == c){
                while(operstack.peek() != '(') numstack.push(calculate(numstack, operstack));
                operstack.pop();//弹出左括号
            }else numstack.push(Character.getNumericValue(c));
        }
        while (!operstack.isEmpty()) numstack.push(calculate(numstack, operstack));
        return numstack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' ||c == '/';
    }

    private static int calculate(Stack<Integer> numStack, Stack<Character> operStack){
        int right = numStack.pop();
        char c = operStack.pop();
        switch (c) {
            case ('+'):
                return numStack.pop() + right;
            case ('-'):
                return numStack.pop() - right;
            case ('*'):
                return numStack.pop() * right;
            default :
                return numStack.pop() / right;
        }
    }

}
