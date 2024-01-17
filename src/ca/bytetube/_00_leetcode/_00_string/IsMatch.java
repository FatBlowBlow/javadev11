package ca.bytetube._00_leetcode._00_string;


import java.util.HashMap;

/**
 * 两个str， str1 & str2
 * str1的character rearrange后是否能和str2 match
 * example：str1 "rgwchohld", str2"world" --> true
 *          str1 "golf", str2"dog" --> false
 */
public class IsMatch {

    public static void main(String[] args) {
        String str1 = "dolfg";
        String str2 = "dog";
        System.out.println(isMatch(str1, str2));

    }

    public static boolean isMatch (String str1, String str2){
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return false;
        char[] chars = str1.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : chars){
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            if (map.containsKey(str2.charAt(i)) && map.get(str2.charAt(i)) >= 1) {
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
            }
            else return false;
        }
        return true;
    }



}
