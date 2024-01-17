package ca.bytetube._11_recursion;

public class PrintAllSubSequenceOfString {
    public static void main(String[] args) {
        printAllSubSequenceOfString("abc");
    }

    public static void printAllSubSequenceOfString(String s) {
//        String res = new String();
        printAllSubSequenceOfString(s,0,new String());
    }

    public static void printAllSubSequenceOfString(String s, int index, String res) {

        if (index == s.length()){
            System.out.println(res);
            return;
        }

        //string --> char[] ---> index = 0
        printAllSubSequenceOfString(s,index + 1, res);//no
        printAllSubSequenceOfString(s, index + 1, res + s.charAt(index));//yes

    }


}