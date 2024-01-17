package ca.bytetube._00_leetcode._02_stack;

import ca.bytetube._04_stack.Stack;

public class _856_ScoreOfParentheses {

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(scoreOfParentheses(s));
    }



    public static int scoreOfParentheses(String s) {
        if (s.length() == 0 || s == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(-1);
            else if (stack.peek() == -1) {//c=')',并且上一个是'('
                    stack.pop();
                    stack.push(1);
            }else {//c=')',并且上一个是')'
                while(stack.peek() != -1) sum += stack.pop();
                stack.pop();
                stack.push( sum << 1);
                sum = 0;
            }
        }
        while (!stack.isEmpty())  sum += stack.pop();
        return sum;
    }

    //count cores --> core, a substring () with score 1 -->算exterior嵌套了几层
    //(()(())) --> (()) + ((()))
    public static int scoreOfParentheses2(String s) {
       int res = 0, depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') depth++;//with each '(' the depth increased by 1
            else {
                depth--;
                if (s.charAt(i - 1) == '(') res += 1 << depth;
            }
        }
        return res;
    }


    /**
     * stack
     * When comes to an opening bracket, increase depth, and our score at the new depth is 0.
     * When comes to a closing bracket, add twice the score of the previous deeper part.
     * when counting (), which has a score of 1.
     */
    public static int scoreOfParentheses3(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);//the score of current frame
        for (char c :s.toCharArray()) {
            if (c =='(') stack.push(0);
            else{
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
}
