package ca.bytetube.day16_map;

import java.util.HashMap;
import java.util.Map;

public class CountNumOfString {

    public static void countNumOfString(String s){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }else {
                Integer count = map.get(c);
                map.put(c,++count);
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        String s = "abbbcadeccb";
        countNumOfString(s);
    }



}
