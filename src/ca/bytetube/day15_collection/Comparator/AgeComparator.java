package ca.bytetube.day15_collection.Comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    /**
     *  升序排 p1 - p2, 第一个数 - 第二个数
     *  降序排 p2 - p1, 第二个数 - 第一个数
     */
    @Override
    public int compare(Person p1, Person p2) {
        return p1.age - p2.age;
//        return p2.age - p1.age;
    }
}
