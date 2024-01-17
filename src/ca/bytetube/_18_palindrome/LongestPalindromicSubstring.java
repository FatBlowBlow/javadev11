package ca.bytetube._18_palindrome;


/**
 * leetcode题
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindromicSubstring("ABBABA"));
    }

    private char[] transferCharArray(char[] oldChars){
        char[] cs = new char[(oldChars.length << 1) + 3];
        cs[0] = '^';
        cs[1] = '#';
        cs[cs.length - 1] = '$';
        for (int i = 0; i < oldChars.length; i++) {
            //将原字符数组中的索引转化为新字符数组的索引
            int index = (i + 1) << 1;//左移一位 = x2
            cs[index] = oldChars[i];
            cs[index + 1] = '#';
        }
        return cs;
    }

    public String longestPalindromicSubstring(String s){
        if (s == null) return null;
        if (s.length() <= 1) return s;
        char[] oldChars = s.toCharArray();//把string里的字符放入array中
        char[] cs = transferCharArray(oldChars);//cs数组 -->看ppt的图
        int[] m = new int[cs.length];//m数组 -->看ppt的图

        int r = 0;//回文半径只要小于2
        int c = 0;
        int maxLen = 0;
        int index = 0;//cs数组的index

        for (int i = 2; i < m.length - 2; i++) {//从m数组第三个数开始求，走到倒数第三个位置
            if (i < r) {
                int li = (c << 1) - i;//li是i点关于c的对称点
                m[i] = i + m[li] <= r ? m[li] :  r - i;

//                if (i + m[li] <= r) {
//                    m[i] = m[li];
//                }else {//i + m[li] > r
//                    m[i] = r - i;
//                }
            }

            //以i为对称中心， 向左右两侧拓展
            while (cs[i + m[i] + 1] == cs[i - m[i] - 1]) m[i]++;// cs[i + (m[i] + 1)] == cs[i - (m[i] + 1)]
            //更新c, r
            if (i + m[i] > r) {
                c = i;
                r = i + m[i];
            }

            //更新最大回文子串的长度和开始索引
            if (m[i] > maxLen) {
                maxLen = m[i];
                index = i;
            }
        }

        int beginIndex = (index - maxLen) >> 1;

        return new String(oldChars, beginIndex, maxLen);
    }
}
