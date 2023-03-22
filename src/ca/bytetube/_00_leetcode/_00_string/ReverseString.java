package ca.bytetube._00_leetcode._00_string;



public class ReverseString {

    public static void main(String[] args) {
        String str = "snudhbgl";
        String reversedStr = reverseString(str);
        System.out.println(reversedStr);
    }

    public static String reverseString(String str){
        if (str == null || str.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
