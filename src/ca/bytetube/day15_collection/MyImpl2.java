package ca.bytetube.day15_collection;

public class MyImpl2<E> implements MyGenericInterface<E> {
    private E element;

    @Override
    public void add(E e) {
        element = e;
    }

    @Override
    public E getE() {
        return element;
    }

    public static void main(String[] args) {
        MyImpl2<String> myImpl = new MyImpl2<>();
        myImpl.add("fang");
        System.out.println(myImpl.getE());


        MyImpl2<Long> myImpl2 = new MyImpl2<>();
        myImpl2.add(100l);
        System.out.println(myImpl2.getE());
    }
}
