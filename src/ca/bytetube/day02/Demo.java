package ca.bytetube.day02;

public class Demo {
    public static void main(String[] args) {
        //Integer -> String -> +, 后边拼一个空的字符串，任何类型都可以转换成String
        int i = 10;
        String s = i + "";
        System.out.println(s);
    }
}
