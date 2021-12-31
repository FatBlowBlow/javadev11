package ca.bytetube._17_sequence;

public class KMP {

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

        //next table
        // todo next table
        int[] next = next(pattern);
        while(pi < pLen && ti < tLen){

            //match successfully
            if(pi < 0 || textChars[ti] == patternChars[pi]){//pi = -1
                ti++;
                pi++;
            }else { //match unsuccessfully
                //pi 位置失配
                //ti不用动，等待下一次的匹配
                //特殊情况：parttern的第一个值和text不相同
                //让当前的ti右移一位，pattern回到开头0号位置继续比较,此时从next[pi]=next[0]=-1;
                pi = next[pi];
            }

        }

        return pi == pLen ? (ti - pi) : -1;
    }

    private static int[] next (String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0;
        int n = -1;
        char[] charArray = pattern.toCharArray();
        while (i < charArray.length - 1) {
            //1. Pattern[i] == Pattern[n]
            //then next[i + 1] = n + 1
            if (n < 0 || charArray[i] == charArray[n]) {
                next[++i] = ++n;
            }else {//Pattern[i] != Pattern[n] --> mismatch
                //需要比对 Pattern[i] == Pattern[k]
                //已知 next[n] = k
                //求 next[i + 1] = k + 1
                n = next[n];
            }
        }





        return next;
    }
}
