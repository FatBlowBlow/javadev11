package ca.bytetube.day17_reviewCollection;

import java.util.HashMap;
import java.util.Map;

public class CountNumOfChar {
    public static void main(String[] args) {
        String s = "abbbbdfegrt";
        System.out.println(countNumOfChar(s));

    }

    public static Map<Character, Integer> countNumOfChar(String s){
        //1.参数判断
        if (s == null || s.length() == 0) return null;
        //2.创建map集合
        Map<Character, Integer> map = new HashMap<>();
        //3. 遍历字符串，得到每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //4.判断map中是否有该键
            if (!map.containsKey(c)) {
                map.put(c,1);
            }else {//如果有，说明已经出现过，获取到对应的value值，++并再次储存
                Integer count = map.get(c);
                map.put(c, ++count);
            }
        }
        return map;
    }
}
