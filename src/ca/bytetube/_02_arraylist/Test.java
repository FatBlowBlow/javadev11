package ca.bytetube._02_arraylist;

public class Test {
    public static void main(String[] args) {
//       ArrayList<String> arrayList = new ArrayList<>();
//       arrayList.add("huan");
//       arrayList.add("fang");
//       arrayList.add(null);
//       arrayList.add("shuo");
//       System.out.println(arrayList);

//       arrayList.add(2, "jun");
//       System.out.println(arrayList);
//
//       String removedElement = arrayList.remove(2);
//       System.out.println(removedElement);
//       System.out.println(arrayList);
//
//       arrayList.set(0, "sheng");
//       System.out.println(arrayList);
//
//        String s = arrayList.get(0);
//        System.out.println(s);
//        System.out.println(arrayList);

//        int index = arrayList.indexOf("fang");
//        System.out.println(index);

//        boolean index = arrayList.contains("dal");
//        System.out.println(index);

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person(6, "huan"));
        arrayList.add(new Person(26, "fang"));
        arrayList.add(new Person(56, "sheng"));
        System.out.println(arrayList);


    }
}
