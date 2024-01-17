package ca.bytetube._00_leetcode._02_stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 * + - ( ) 运算
 * - 可以用作负数
 *
 * isDigit(c):判断指定字符是否为数字
 * initial num=0 & num = num * 10 + (c - '0') --> c转换成相对应的int数值
 */
public class _224_BasicCalculator {

    public static void main(String[] args) {
        String s = "1-(     -2)";
        System.out.println(basicCalculator2(s));
    }

    //记录括号前expression的值 + (括号前operator * 括号里expression的值)
    public static int basicCalculator(String s) {
            Stack<Integer> stack = new Stack<>();
            int res = 0, operand = 0, sign = 1;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    operand = operand * 10 + (c - '0');
                } else if (c == '+') {
                    res += sign * operand;//计算'+'左边的表达式并记录
                    operand = 0;//reset operand
                    sign = 1;//记录当前operator
                } else if (c == '-') {
                    res += sign * operand;///计算'-'左边的表达式并记录
                    operand = 0;
                    sign = -1;
                } else if (c == '(') {//左括号和左括号前的operator绑定
                    stack.push(res);
                    stack.push(sign);
                    //重置res,operand,sign像开始那样for new subexpression within parentheses
                    res = 0;
                    operand = 0;
                    sign = 1;
                } else if (c == ')') {//括号里表达式的结束
                    res += sign * operand;//计算')'左边-->括号里的表达式-->括号里expression的值
                    res *= stack.pop();//stack.pop()= previous sign
                    res += stack.pop();//stack.pop()= previous res so far
                    operand = 0;
                }
            }
            if (operand != 0) res += sign * operand;
            return res;
        }

    //击穿括号 --> 通过stack记录()前operator，去括号运算
    public static int basicCalculator2(String s){
        int res = 0, num = 0, sign = 1;
        Stack<Integer> operatorStack = new Stack<>();
        operatorStack.push(1);

        for(char c : s.toCharArray()){
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else{
                res += num * sign * operatorStack.peek();//记录每一次当前c左边expression的res值
                num = 0;
                if (c == '+') sign = 1;
                else if (c == '-') sign = -1;
                else if (c == '('){
                    operatorStack.push(operatorStack.peek() * sign);//记录括号前的operator
                    sign = 1;
                }else if (c == ')') operatorStack.pop();
            }
        }
        res += sign * num;
        return res ;
    }






}
