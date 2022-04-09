package ca.bytetube._05_queue;

import ca.bytetube._04_stack.list.LinkedList;
import ca.bytetube._04_stack.list.List;

public class Queue<E>  {
    private List<E> list = new LinkedList<>();

    public int size(){
        return list.size();
    }

    public void clear(){
        list.clear();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void enQueue(E element){
        list.add(element);
    }

    public E deQueue(){
        return list.remove(0);
    }

    public E front(){
        return list.get(0);
    }
}
