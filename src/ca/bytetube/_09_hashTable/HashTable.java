package ca.bytetube._09_hashTable;

public class HashTable {
    public static void main(String[] args) {
//        System.out.println(Float.floatToIntBits(10.6f));//float to int :1093245338-->hash code of 10.6
//        Integer.toBinaryString(1093245338);//int --> 二进制数

        String s = "jack";
        System.out.println(hash_code(s));

    }


    public static int hash_code(String s){
        int hashCode = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            hashCode = 31 * hashCode + c;
            hashCode = (hashCode << 5) - hashCode + c;
        }

        return hashCode;
    }

}
