package ca.bytetube.day16_map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        //向map中添加元素
        add("fangtube", "fang", map);
        add("apple", "jobs", map);
        add("tesla", "mask", map);
        add("tesla", "shuo", map);
        System.out.println(map);

        String removed = map.remove("apple");
        System.out.println(removed);
        System.out.println(map);

        String s = map.get("fangtube");
        System.out.println(s);

        String s1 = map.get("apple");
        System.out.println(s1);//null

        boolean s2 = map.containsKey("apple");
        System.out.println(s2);




    }

    public static void add(String key, String value, Map<String, String> map){
        if (!map.containsKey(key)) {
            map.put(key, value);
        }
    }
}
