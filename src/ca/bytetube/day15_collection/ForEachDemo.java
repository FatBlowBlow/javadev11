package ca.bytetube.day15_collection;

public class ForEachDemo {
    public static void main(String[] args) {
        String[] persons = {"fang","huan","jun","sheng"};

        //iterator的演变，从头到尾遍历
        for (String person : persons) {
            System.out.println(person);
        }
    }
}
