package ca.bytetube._17_sequence;

public class BruteForce {

    public static void main(String[] args) {
        String text = "Hello World";
        System.out.println(indexOf(text, "or"));
        System.out.println(indexOf(text, "other"));
    }


    public static int indexOf(String text, String pattern){
        if (text == null || pattern == null) return -1;

        int pLen = pattern.length();
        int tLen = text.length();

        if (pLen == 0 || tLen == 0) return -1;
        if (tLen < pLen) return -1;

        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();


        int pi = 0;
        int ti = 0;
        while(pi < pLen && ti < tLen){

            //match successfully
            if(textChars[ti] == patternChars[pi]){
                ti++;
                pi++;
            }else { //match unsuccessfully
                ti -= pi -1;
                pi = 0;

            }

        }

        return pi == pLen ? (ti - pi) : -1;
    }
}
