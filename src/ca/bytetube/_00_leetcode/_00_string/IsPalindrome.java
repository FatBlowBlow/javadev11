package ca.bytetube._00_leetcode._00_string;

import ca.bytetube._04_stack.Stack;

public class IsPalindrome {
    public static void main(String[] args) {
        String str = "aabca";
        System.out.println(isPalindrome(str));;
    }

    private static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();

        for (char c : chars) stack.push(c);

        for (int i = 0; i < str.length(); i++) if (stack.pop() != str.charAt(i)) return false;
        return true;
    }
}
