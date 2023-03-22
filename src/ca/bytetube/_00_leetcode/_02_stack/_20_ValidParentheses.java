package ca.bytetube._00_leetcode._02_stack;


import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class _20_ValidParentheses {
    static HashMap<Character,Character> map = new HashMap<>();//静态，节省memory
    static{//静态代码块，对map进行初始化
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }


    public boolean isValid(String s) {//自己做的
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '('){
                stack.push(chars[i]);
            }else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
//                if (pop == '{' && chars[i] == '}') continue;
//                if (pop == '[' && chars[i] == ']') continue;
//                if (pop == '(' && chars[i] == ')') continue;
                if ( (pop == '{' && chars[i] == '}') || (pop == '[' && chars[i] == ']') ||
                     (pop == '(' && chars[i] == ')') )continue;
                else return false;
            }
        }
        return stack.isEmpty()? true : false;
    }


    public boolean isValid2(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果遍历过程中遇到左括号，压栈
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }else {//遍历得到的一定是右括号
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '[' && c != ']') return false;
                if (left == '{' && c != '}') return false;
            }
        }
        return  stack.isEmpty()? true : false;
    }

    /**
     * 利用HashMap
     * key:左括号
     * value:右括号
     */
    public boolean isValid3(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //如果遍历过程中遇到c=左括号，压栈
            if (map.containsKey(c)){
                stack.push(c);
            }else {//c:遍历得到的一定是右括号
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (map.get(pop) != c) return false;
            }
        }
        return  stack.isEmpty()? true : false;

    }


    public boolean isValid4(String s) {//不建议，时间法度太大了
        if (s == null) return false;
        while (s.contains("()") || s.contains("[]") || s.contains("{}") ){
            s.replace("()", "");
            s.replace("[]", "");
            s.replace("{}", "");
        }
        return s.isEmpty()? true : false;
    }


}
