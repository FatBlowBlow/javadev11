package ca.bytetube.day17_reviewCollection;

import java.util.ArrayList;

import java.util.Collection;

public class ArrayToCollection {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        Collection<Integer> list = arrayToCollection(arr);
        System.out.println(list);
    }

    private static Collection<Integer> arrayToCollection(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Collection<Integer> collection = new ArrayList<>();
        for (int element : arr) {
            collection.add(element);
        }
        return collection;
    }
}
