package ca.bytetube._00_leetcode._05_map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class countCharNumInString {
    public static Map<Character,Integer> countCharNumInString(String str){

        if(str == null) throw new NullPointerException("string can not be null");

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                int num = map.get(c);
                map.put(c,num + 1);
            }else{
                map.put(c,1);
            }
        }
        return map;
    }

    public static List countCharNumInString1(String str){
        if(str == null) throw new NullPointerException("string can not be null");

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            int index = Integer.valueOf(str.charAt(i));
            if(list.get(index) == null) list.add(index,1);
            list.add(index,list.get(index)+1);
        }

        List<String> result = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != null){
                String s = Character.toString((char)i) + list.get(i);
                result.add(s);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(countCharNumInString1("aaddftyerrc"));
    }
}
