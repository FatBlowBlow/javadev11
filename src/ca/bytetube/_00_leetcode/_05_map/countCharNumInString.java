package ca.bytetube._00_leetcode._05_map;

import java.util.*;

public class countCharNumInString {

    //hashmap
    public static Map<Character,Integer> countCharNumInString(String str){
        if(str == null) throw new NullPointerException("string can not be null");

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                int num = map.get(c);//得到相应key的value
                map.put(c,num + 1);
            }else{
                map.put(c,1);//map中放入entry（键值对）---> (key, value)
            }
        }
        return map;
    }


    //list
//    public static List countCharNumInString1(String str){
//        if(str == null) throw new NullPointerException("string can not be null");
//
//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < str.length(); i++) {
//            int index = Integer.valueOf(str.charAt(i));
//            if(list.get(index) == null) list.add(index,1);
//            list.add(index,list.get(index)+1);
//        }
//
//        List<String> result = new LinkedList<>();
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i) != null){
//                String s = Character.toString((char)i) + list.get(i);
//                result.add(s);
//            }
//        }
//        return result;
//    }

    public static List<ListEntry> countCharNum (String string){
        ArrayList<ListEntry> arrayList = new ArrayList<>();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ListEntry entry = new ListEntry();
            entry.setKey(chars[i]);
            if(arrayList.contains(entry)){
                arrayList.get(arrayList.indexOf(entry)).value += 1;
            }else {
                entry.setValue(1);
                arrayList.add(entry);
            }
        }

        return arrayList;
    }

    private static class ListEntry{
        Character key;
        Integer value;

        public Character getKey() {
            return key;
        }

        public void setKey(Character key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }


        @Override
        public boolean equals(Object o) {//一定要重写，为了contains比较
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListEntry listEntry = (ListEntry) o;
//            return Objects.equals(key, listEntry.key) && Objects.equals(value, listEntry.value);
            char cKey = this.key;
            char otherKey = listEntry.key;
            return cKey == otherKey;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return  key +
                    "=" + value ;
        }
    }

    public static void main(String[] args) {
        System.out.println(countCharNum("aaddftyerrc"));
    }
}
