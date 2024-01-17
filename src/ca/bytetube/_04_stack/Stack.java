package ca.bytetube._04_stack;


import ca.bytetube._04_stack.list.LinkedList;
import ca.bytetube._04_stack.list.List;

public class Stack<E> {//stack的底层是list
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

    public void push(E element){
        list.add(element);
    }

    public E pop(){
        return list.remove(list.size() - 1);
    }

    public E peek(){
        return list.get(list.size() - 1);
    }

}
