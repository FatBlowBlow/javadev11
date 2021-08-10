package ca.bytetube._13_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {
    public static void main(String[] args) {
        String[] strings = {"abc", "ab", "bc"};
        Arrays.sort(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    public static String lowestLexicography(String[] strs){
        if (strs == null || strs.length == 0) return " ";
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String res = " ";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}
