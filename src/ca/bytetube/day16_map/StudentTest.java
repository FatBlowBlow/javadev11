package ca.bytetube.day16_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class StudentTest {
    public static void main(String[] args) {
        //1. 创建map集合
//        Map<Student, String> map = new HashMap<>();//HashMap，无序
        Map<Student, String> map = new LinkedHashMap<>();//LinkedHashMap, 有序
        //2. 添加元素
        map.put(new Student("fang", 26), "mtl");
        map.put(new Student("shuo", 27), "van");
        map.put(new Student("jun", 52), "trt");
        map.put(new Student("sheng", 56), "ny");
        //3. 取出元素
        Set<Student> keySet = map.keySet();
        for (Student key : keySet) {
            String value = map.get(key);
            System.out.println(key + " lives in " + value);
        }
    }
}
