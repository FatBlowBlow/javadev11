package ca.bytetube.day16_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo02 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("fang", "fangtube");
        map.put("jobs", "apple");
        map.put("mask", "tesla");

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
//            System.out.println(key);
            String value = map.get(key);
            System.out.println(key + "的公司是"+ value);


        }


    }
}
