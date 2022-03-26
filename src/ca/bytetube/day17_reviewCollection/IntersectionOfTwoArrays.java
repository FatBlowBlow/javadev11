package ca.bytetube.day17_reviewCollection;

import java.net.BindException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
//        int[] arr1 = {4,9,5};
//        int[] arr2 = {9,4,9,8,4};
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,2};
        printArray(intersectionOfTwoArrays(arr1, arr2));
    }

    public static Integer[] intersectionOfTwoArrays(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length ; i++) {
            for (int j = 0; j < arr2.length ; j++) {
                if (arr1[i] == arr2[j]) {
                    set.add(arr1[i]);
                }
            }
        }
        Integer[] arr = new Integer[set.size()];
        return set.toArray(arr);
    }

    public static Integer[] intersectionOfTwoArrays2(int[] arr1, int[] arr2){
        //1. array transfer to set
        HashSet<Integer> set1 = arrayToCollection(arr1);
        HashSet<Integer> set2 = arrayToCollection(arr2);
        if (set1.size() < set2.size()) {
            return compareElementInSet(set1, set2);
        }else {
            return compareElementInSet(set2, set1);
        }
    }


    private static HashSet<Integer> arrayToCollection(int[] arr){
        if (arr == null || arr.length == 0) return null;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set;
    }

    private static Integer[] compareElementInSet(HashSet<Integer> setS, HashSet<Integer> setL){
        Integer[] res = new Integer[setS.size()];
        int index = 0;
        for (Integer i: setS) {
            if (setL.contains(i)) res[index++] = i;
        }
        return Arrays.copyOf(res, index);
    }

    private static void printArray(Integer[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
