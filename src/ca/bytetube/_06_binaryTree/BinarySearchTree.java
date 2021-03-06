package ca.bytetube._06_binaryTree;


import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree<E> {

    private Comparator<E> comparator;

    public BinarySearchTree() {}//无参数，直接创建BST，要求加的元素必须具备可比较性。

    //必须传入比较器
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    //传入visitor访问器,visitor pattern
    public static abstract class Visitor<E> {
        boolean stop;
        public abstract boolean visit(E element);//boolean使访问器具备一定可控性
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null !");
        }
    }

    /**
     * add(), remove() 放在BST中：
     * 1. 这两种方法是基于比较的，专门针对与BST，其他的没有意义
     * 2. 做树形结构是为了提高增删改查的效率，如果树形结构没有按照一定逻辑顺序的话,
     *    add/remove对提高效率没有意义,树形结构做出来也没有意义
     */
    //add elements（BST的元素插入一定是叶节点）
    public void add(E element) {
        //1.对元素进行非空判断
        elementNotNullCheck(element);
        //添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        //添加不是第一个节点，即普通位置的添加
        //2.定位插入节点的父节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;//在node向左向右移动之前，先记录
            if (cmp > 0) {
                node = node.right;
            }else if (cmp < 0) {
                node = node.left;
            }else {//cmp = 0
                node.element = element;
                return;
            }
        }

        //3.确定插入到父节点的左子树还是右子树
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        size++;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }


    public Node<E> getNode(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);//只有BST才是基于比较的,所以不移到binaryTree
            if (cmp == 0) {
                return node;
            }else if (cmp > 0) {
                node = node.right;
            }else {//cmp < 0
                node = node.left;
            }
        }
        return null;
    }


    //remove elements
    public void remove(E element) {
        remove(getNode(element));
    }

    public void remove(Node<E> node) {
        if (node == null) return;
        //1. degree = 2，这个节点的前驱点 and 后驱点的度只能是1 or 0
        //先用前驱点 or 后继点的值overwrite当前节点，再删除前驱点 or 后继点
        if (node.hasTwoChildren()) {
            Node<E> s = successor(node);//先找到当前节点的后继点
            node.element = s.element;//后继点的值overwrite当前节点的值（值覆盖）
            node = s;//删除后继点，把后继点赋予node --> 转化成删除度为1 or 0的点，整个代码中node始终是要被删除的点
        }

        Node<E> replacement = node.left != null? node.left : node.right;

        //2. degree = 1
        if (replacement != null) {//右可能为空，还得判断
            replacement.parent = node.parent;//更改replacement parent

            //特殊情况, node是degree = 1的root节点
            if (node.parent == null) {
                root = replacement;
            }

            //node.parent != null, 更改parent的孩子
            if (node == node.parent.left) {//node是degree = 1且node是之前parent的left
                node.parent.left = replacement;
            }else {//node是degree = 1且node是之前parent的right
                node.parent.right = replacement;
            }
        }
        //3. degree = 0
        else if (node.parent == null) {//特殊情况, 删到只剩最后一个root节点
            root = null;
        }else {//leaf node
            if (node == node.parent.left) {
                node.parent.left = null;
            }
            if (node == node.parent.right) {
                node.parent.right = null;
            }
        }
        size--;
    }


    //does it contains an element or not
    public boolean contains(E element) {
        return getNode(element) != null;
    }
}





