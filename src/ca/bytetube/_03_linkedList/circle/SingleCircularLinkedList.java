package ca.bytetube._03_linkedList.circle;

import ca.bytetube._03_linkedList.AbstractList;

public class SingleCircularLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    private static class Node<E>{
        E element;//值域 --> element
        Node<E> next;//指针域 --> next

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Iterator: 对容器(没有index)进行遍历的工具
     */
    private Node<E> getNode(int index){
        rangeCheck(index);
        Node<E> node = first;//first指向的是头节点
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;//58:22
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E oldElement = node.element;
        node.element = element;//赋值操作--->从等号的右向左赋值
        return oldElement;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {//对无效值的查找
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        }else {//有效值
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {//head node

            //这种写法是错误的，忽略了空链表插入第一个节点的情况
//            first = new Node(element, first);
//            Node<E> last = getNode(size - 1);
//            last.next = first;
            Node<E> newFirst = new Node<>(element, first);
            Node<E> last = (size == 0) ? newFirst : getNode(size - 1);
            last.next = newFirst;
            first = newFirst;
        }else {
            //普通位置的add
            Node<E> preNode = getNode(index - 1);
            preNode.next = new Node(element, preNode.next);
        }
        size++;
    }



    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> removedNode = first;
        //头删
        if (index == 0) {
            if (size == 1) {//链表里只有一个node
                first = null;
            }else {
                Node<E> last = getNode(size - 1);
                first = first.next;
                last.next = first;
            }
        }else {//普通位置和尾部删除
            Node<E> preNode = getNode(index - 1);
            removedNode = preNode.next;
            preNode.next = removedNode.next;
        }
        size--;
        return removedNode.element;
    }




    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("size:").append(size).append(", {");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            sb.append(node.element);
            node = node.next;
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
