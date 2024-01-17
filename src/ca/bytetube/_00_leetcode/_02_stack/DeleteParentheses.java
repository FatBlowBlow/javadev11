package ca.bytetube._00_leetcode._02_stack;


import java.util.HashMap;
import java.util.Stack;

/**
 * 一个str，有很多左右括号，必须返回全部匹配的括号，需要删除几个括号
 * example: "(((()" -->得删除3个 --> return 3
 *          "(())))" -->得删除2个 --> return 2
 */
public class DeleteParentheses {

    public static void main(String[] args) {
        String str = "(())))";
        System.out.println(deleteParentheses(str));
    }


    public static String deleteParentheses(String str){
        if (str == null || str.length() == 0 ) return null;
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') stack.push(chars[i]);
            else {//遇到的是")"
               if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
               else stack.push(chars[i]);
            }
        }
        String res = Integer.toString(stack.size());
        return res;
    }
}
