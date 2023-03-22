package ca.bytetube._00_leetcode._02_stack;

import java.util.Stack;

/**
 * 加减乘除运算，有小括号先算小括号里边的
 * 从左到右计算，先乘除后加减
 */
public class ArithmeticMath {
    public static void main(String[] args){
        String s = "(1+2)*3-(3/1)";
//        System.out.println("value :" + s);
//        System.out.println("value :" + s.trim());//删除头尾空白符的字符串.
        System.out.println(arithmeticMath(s));

    }

   public static int arithmeticMath(String s){
        //Java中的trim()函数去除了字符串前后两端的所有包括空格、换行、回车.
        s = s.replace(" ", "").trim();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
           if (c == '+' || c == '-' || c == '*' ||c == '/') {
               if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                   calculate(numStack, operatorStack);
               }
               operatorStack.push(c);
           }else if (c == '('){
               operatorStack.push(c);
           }else if (c == ')'){
               calculate(numStack, operatorStack);
               operatorStack.pop();//把左括号去掉
           }else{
               numStack.push(Character.getNumericValue(c));
           }
        }
        calculate(numStack,operatorStack);
        return numStack.pop();
   }

   private static void calculate(Stack<Integer> numStack, Stack<Character> operatorStack ){
       Integer right = numStack.pop();
       Integer left = numStack.pop();
       Character operator = operatorStack.pop();
       switch(operator){
           case ('+'): numStack.push(left + right);
           case ('-'): numStack.push(left - right);
           case ('*'): numStack.push(left * right);
           default : numStack.push(left / right);
       }
   }

}
