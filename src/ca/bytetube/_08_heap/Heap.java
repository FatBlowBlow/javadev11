package ca.bytetube._08_heap;

public interface Heap<E> {
    public int size();
    public boolean isEmpty();
    public void clear();
    public void add(E element);
    public E get();//get the top element of the heap
    public E remove();//delete the top element of the heap
    public E replace(E element);
    //insert a new element while deleting the top element of the heap

}
