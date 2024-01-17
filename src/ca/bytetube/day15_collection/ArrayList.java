package ca.bytetube.day15_collection;

public class ArrayList<E> {

    public E[] array ;
    public int size = 0;

    public ArrayList(E[] array) {
        this.array = array;
    }

    public void add(E e){
        array[0] = e;
        size++;
    }

    public E get(int index){
        return array[index];
    }

    public static void main(String[] args) {
        String[] s = new String[10];
        ArrayList<String> sList = new ArrayList<>(s);//JDK1.8以上，后边<>中的String可以省略
        sList.add("fang");
        System.out.println(sList.get(0));

        Integer[] arr = new Integer[10];
        ArrayList<Integer> iList = new ArrayList<>(arr);
        iList.add(19);
        System.out.println(iList.get(0));;
    }
}
