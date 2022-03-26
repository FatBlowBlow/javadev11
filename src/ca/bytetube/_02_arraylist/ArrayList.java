package ca.bytetube._02_arraylist;



import java.util.Arrays;

/**
 * javaDoc
 * @param <E>
 */
public class ArrayList<E> {
    private int size;//有效元素的个数
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 15;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList() {
        this(DEFAULT_CAPACITY);//构造方法内调
    }

    public ArrayList(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }


    /**
     * size of arraylist
     * @return size of arraylist
     */
    public int size(){
        return size;
    }


    /**
     * clear elements in arraylist
     * gc root --- tag --- reference variable
     */
    public void clear(){
        size = 0;
    }

    /**
     * whether arraylist is empty
     * @return
     */
    public boolean isEmpty(){
         return size == 0;
    }

    /**
     * insert element in tail position of arraylist
     */

    public void add(E element){
        add(size, element);
    }

    /**
     * insert element in certain position of arraylist
     * @param index
     * @param element
     */
    public void add(int index, E element){
        rangeCheckForAdd(index);
        capacityCheck(size + 1);
        for (int i = size; i > index ; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    private void capacityCheck(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //扩容,一般扩1.5倍 (官方)
        int newCapacity =oldCapacity + (oldCapacity >> 1); //1.5 = 1+0.5
        E[] newElements = (E[]) new Object[newCapacity];
        //数据转移
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) outOfBounds(index); // index能等于size
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) outOfBounds(index);
    }

    private void outOfBounds (int index){
        throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }


    public E remove(int index){
        rangeCheck(index);
        E removedElement = elements[index];
        for (int i = index + 1; i < size; i++) {
           elements[i - 1] = elements[i];
        }
//        elements[size - 1] = null;
//        size--;
        elements[--size] = null;
        return removedElement;
    }

    public E set(int index, E element){//返回老值
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }


    public int indexOf(E element){
        if (element == null) {//对无效值的查找
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        }else {//有效值
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
