package ca.bytetube.day17_reviewCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class CollectionToArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        Integer[] array = collectionToArray2(list);
        printArray(array);

    }

    public static Integer[] collectionToArray(Collection<Integer> collection){
        if (collection == null || collection.size() == 0) return null;
        Object[] objects = collection.toArray();
        Integer[] intArray = new Integer[objects.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (Integer) objects[i];
        }
        return intArray;

    }

    public static Integer[] collectionToArray2(Collection<Integer> collection){
        if (collection == null || collection.size() == 0) return null;
        Integer[] intArray = new Integer[collection.size()];
        intArray = collection.toArray(intArray);
        return intArray;
    }

    public static Object[] collectionToArray3(Collection<Object> collection){
        if (collection == null || collection.size() == 0) return null;
        Object[] array = new Object[collection.size()];
        for (int i = 0; i < array.length ; i++) {
            Iterator<Object> iterator = collection.iterator();
            if (iterator.hasNext()){
                Object o = iterator.next();
                array[i] = o;
                collection.remove(o);
            }
        }
        return array;
    }

    private static void printArray(Integer[] integerArray){
        for (Object o: integerArray) {
            System.out.print(o + " ");
        }
    }
}
