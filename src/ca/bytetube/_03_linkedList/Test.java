package ca.bytetube._03_linkedList;


import ca.bytetube._03_linkedList.circle.CircleLinkedList;

public class Test {
    public static void main(String[] args) {
        testList(new CircleLinkedList<>());

//        AbstractList<String> linkedList = new LinkedList<>();
//        linkedList.add("fang");
//        linkedList.add("shuo");
//        linkedList.add("huan");
//        System.out.println(linkedList);
//
//        linkedList.remove(0);
//        System.out.println(linkedList);
//
//        int index = linkedList.indexOf("huan");
//        System.out.println(index);
//
//        boolean huan = linkedList.contains("huan");
//        System.out.println(huan);
//
//        linkedList.add(0, "jun");
//        System.out.println(linkedList);
//
//        String s = linkedList.get(0);
//        System.out.println(s);
//
//        linkedList.set(0,"sheng");
//        System.out.println(linkedList);

    }


    public static void testList(List<Integer> list){
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55);//[55,11,22,33,44]
        list.add(2, 66);//[55,11,66,22,33,44]
        list.add(list.size(), 77);//[55,11,66,22,33,44,77]

        list.remove(0);//[11,66,22,33,44,77]
        list.remove(2);//[11,66,33,44,77]
        list.remove(list.size() - 1);//[11,66,33,44]

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(99) == List.ELEMENT_NOT_FOUND);

        System.out.println(list);

    }
}
