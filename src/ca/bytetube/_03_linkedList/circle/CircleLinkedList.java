package ca.bytetube._03_linkedList.circle;

import ca.bytetube._03_linkedList.AbstractList;

public class CircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;


    private static class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            }else{
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            }else{
                sb.append("null");
            }

            return sb.toString();
        }
    }

    private Node<E> getNode(int index){
        rangeCheck(index);
        if (index < (size >> 1)) {//index在前半部分
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else {//index在后半部分
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }


    @Override
    public void clear() {
        first = null;
        size = 0;
        last = null;
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
    public void add(int index, E element) {
       rangeCheckForAdd(index);
        //尾插
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, first);//newLast
            //last = newLast;
            if (size == 0) {//插入时链表为空，插入第一个节点
                first = last;
                last.next = last;//自己指向自己
                last.prev = last;//自己指向自己
            }
            else {
                oldLast.next = last;
                first.prev = last;
            }

        }else{
            //普通位置的插入
            Node<E> next = getNode(index);//变成插入新node后的next点
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            prev.next = node;
            //头插
            if (index == 0) first = node;

        }
        size++;
    }


    @Override
    public E remove(int index) {
       rangeCheck(index);

        Node<E> node = getNode(index);
        if (size == 1) {//链表删除到只剩一个节点
            first = null;
            last = null;
        }else {
            //普通位置
            Node<E> prevNode = node.prev;
            Node<E> nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            //头删
            if (node == first) first = nextNode;
            //尾删
            if (node == last) last = prevNode;
        }
        size--;

        return node.element;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size:").append(size).append(", {");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(node.toString());
            node = node.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
