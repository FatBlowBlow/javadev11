package ca.bytetube._08_heap;

import ca.bytetube._08_heap.printer.BinaryTreeInfo;

import java.util.Comparator;
//maximum heap

public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;//底层结构是数组
    private static final int DEFAULT_CAPACITY = 15;


    public BinaryHeap(Comparator<E> comparator, E[] elements) {//双参
        super(comparator);
        if (elements == null || elements.length == 0){
            this.elements =(E[]) new Object[DEFAULT_CAPACITY];
        }else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements =(E[]) new Object[capacity];
        }

        for (int i = 0; i < size; i++) {
            this.elements[i] = elements[i];
        }
        heapify();
    }

    public BinaryHeap(E[] elements) {//单参
        this(null, elements);
    }

    public BinaryHeap(Comparator<E> comparator) {//单参
        this(comparator, null);
    }

    public BinaryHeap() {//无参
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];//创建了一个default长度的数组
//        this(null,null);
    }



    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    /**
     * 往heap里添加:
     * 1.判断元素不为空
     * 2.看capacity够不够，不够的话扩容。
     * 4.如果够，添加到数组的最后一个位置
     * 5.调整为maximum heap --> 和他的parent做比较，不停上移 --> siftUp
     * Loop : if node > parent --> swap with parent
     *        if node <= parent, or node has no parent --> exist loop
     * This process is called: sift up
     * n * O(logn)
     */
    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;//size-1是添加前最后一个有效元素的位置，添加后，最后一个有效元素的位置是size
//        size++;
        siftUp1(size - 1);

    }

    /**
     * heap里删除
     *1.cover the root node with the last one
     *2.delete the last node
     *3.从左右孩子中选出较大值，比较，swap，点下移 --> siftDown
     *Loop : if node < child --> swap with child
     *       if node >= child, or node has no child --> exist loop
     *This process is called: sift down
     */
    @Override
    public E remove() {
        emptyCheck();
        int lastIndex = --size;//索引
        E root = elements[0];//值
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);
        return root;

    }


    @Override
    public E replace(E element) {
        //1.简单粗暴方法
//        E root = remove();
//        add(element);
//        return root;

        //2.优化
        E root = elements[0];//记录要删除的头节点
        elements[0] = element;//新添加的节点放到头节点上
        siftDown(0);//从新添加节点的位置开始siftDown，调整为maximum heap
        return null;
    }

    private void siftUp(int index) {
        E e = elements[index];//拿到数
        while(index > 0){
            int parentIndex = (index - 1) >> 1;
            E parent = elements[parentIndex];
            //2. node <= parent
            if (compare(e,parent) <= 0) return;//return或者break都可以，因为出了循环就没有内容需要执行

            //1. node > parent --> swap
            E temp = elements[index];
            elements[index] = elements[parentIndex];
            elements[parentIndex] = temp;
            index = parentIndex;//更新index，为了让siftUp不断向上
        }
    }

    /**
     * 优化siftUp
     * 一直和parent向上比较，上升index，只有index交换
     * 最后一次赋值
     * O(logn) + 1
     */
    private void siftUp1(int index) {
        E e = elements[index];
        while(index > 0){
            int parentIndex = (index - 1) >> 1;
            E parent = elements[parentIndex];
            //2. node <= parent
            if (compare(e,parent) <= 0) break;//loop外还有要执行的语句

            //1. node > parent --> swap
            elements[index] = parent;//parent的数值向下降
            index = parentIndex;
        }
        elements[index] = e;
    }


    private void siftDown(int index) {
        E element = elements[index];//先记录值，然后和他child的值进行比较，比child小-->下移
        //no child --> exist --> 下移的节点一定是非叶子节点 --> 在第一个叶子节点之前
        int half = size >> 1;//第一个叶子节点的索引
        //必须保证index位置是非叶子节点
        while(index < half){
            //index所对应的节点只有两种情况
            //1.only left child
            //2.left child & right child
            //默认跟left进行比较
            int childIndex = (index << 1) + 1;//left child
            E child = elements[childIndex];

            int rightIndex = childIndex + 1;

            //选出左右孩子中最大值
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
//                childIndex = rightIndex;
                child = elements[childIndex = rightIndex];
            }

            if (compare(element,child) >= 0) break;//loop外还有要执行的语句
            elements[index] = child;
            //更新index
            index = childIndex;
        }

        elements[index] = element;

    }


    private void emptyCheck() {
        if (size == 0) {
            throw new IllegalArgumentException("heap must not be empty");
        }
    }

    private void elementNotNullCheck(E element){
        if (element == null) {
            throw new NullPointerException("element must not be null");
        }
    }

    private void ensureCapacity (int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;

        //扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);//1 + 0.5 = 1.5

        E[] newElements = (E[]) new Object[newCapacity];

        //数据转移
        for (int i = 0; i < size; i++) {
            newElements[i] =  elements[i];
        }
        elements = newElements;

    }

    //堆化。把一个无序整数数组变成一个maximum heap
    private void heapify(){

        //1.top --> down， sift up
        for (int i = 0; i < size; i++) {
            siftUp(i);
        }

        //2.bottom --> up， sift down, 从非叶子节点开始
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public Object root() {//二叉堆中传index
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int)node << 1) + 1;//乘2加1
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int)node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int)node];
    }
}
