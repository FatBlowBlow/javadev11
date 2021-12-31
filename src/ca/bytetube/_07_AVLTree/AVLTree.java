package ca.bytetube._07_AVLTree;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {
    public AVLTree() {}

    public AVLTree(Comparator<E> comparator) { super(comparator); }


    private static class AVLNode<E> extends Node<E>{
        int height = 1;//任何一个节点的默认高度为1
        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor(){//对树当中的每一个节点
            int leftHeight = this.left == null? 0 : ((AVLNode<E> )this.left).height;
            int rightHeight = this.right == null? 0 : ((AVLNode<E> )this.right).height;
            return leftHeight - rightHeight;
        }

        private void updateHeight() {
            int leftHeight = this.left == null? 0 : ((AVLNode<E> )this.left).height;
            int rightHeight = this.right == null? 0 : ((AVLNode<E> )this.right).height;
            height = Math.max(leftHeight, rightHeight) + 1;
        }


        public Node<E> tallerChild(){
            int leftHeight = this.left == null? 0 : ((AVLNode<E> )this.left).height;
            int rightHeight = this.right == null? 0 : ((AVLNode<E> )this.right).height;
            if(leftHeight > rightHeight) return left;
            if(leftHeight < rightHeight) return right;
            return this.isLeftChild() ? left : right;//leftHeight = rightHeight
        }


    }

    protected  Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<> (element, parent);
    }

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E> )node).balanceFactor()) <= 1;//平衡因子取绝对值
    }

    private void updateHeight(Node<E> node){//更新高度时，统一把普通node转型AVLNode
        ((AVLNode<E> )node).updateHeight();
    }

    //添加后， 可能导致所有的非父的祖先节点失衡，所以从最低的失衡节点开始调-->只调一次-->下边平衡-->上边的都会平衡
    public void afterAdd(Node<E> node){//新添加的节点，node is leaf node
        while ((node = node.parent) != null){//一直向上找
            if (isBalanced(node)) {//判断每个节点是否平衡
                //更新高度
                updateHeight(node);
            }else {
                rebalance(node);
                break;//从下向上调平，只需调平一次
            }
        }
    }


    /**
     * 4种情况, LL,RR,LR,RL
     * @param grand
     */
    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E> )grand).tallerChild();
        Node<E> node = ((AVLNode<E> )parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//LL
                rotateRight(grand);
            }else {//LR
                rotateLeft(parent);
                rotateRight(grand);
            }

        }else {//R
            if (node.isLeftChild()) {//RL
                rotateRight(parent);
                rotateLeft(grand);
            }else {//RR
                rotateLeft(grand);
            }
        }
    }



    /**
     * 天下归一法
     * @param grand：失衡节点
     */
    private void rebalance2(Node<E> grand) {
        Node<E> parent = ((AVLNode<E> )grand).tallerChild();
        Node<E> node = ((AVLNode<E> )parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//LL
                rotate(grand, node.left, node, node.right, parent, parent.right, grand, grand.right);
            }else {//LR
                rotate(grand, parent.left, parent, node.left, node, node.right, grand, grand.right);

            }

        }else {//R
            if (node.isLeftChild()) {//RL
                rotate(grand, grand.left, grand, node.left, node, node.right, parent, parent.right);
            }else {//RR
                rotate(grand, grand.left, grand, parent.left, parent, node.left, node, node.right);
            }
        }
    }


    private void rotate(Node<E> r,//需要拿到最开始子树的根节点的parent，作为d点的parent
                        Node<E> a,Node<E> b,Node<E> c,
                        Node<E> d,
                        Node<E> e,Node<E> f,Node<E> g){

        //d点:让d点成为root
        d.parent = r.parent;
        if (r.isLeftChild()) {
            r.parent.left = d;

        }else if(r.isRightChild()) {
            r.parent.right = d;

        }else {
            root = d;
        }

        //a-b-c
        b.left = a;
        if (a != null) {
            a.parent = b;
        }

        b.right = c;
        if (c != null) {
            c.parent = b;
        }
        updateHeight(b);

        //e-f-g
        f.left = e;
        if (e != null) {
            e.parent = f;
        }

        f.right = g;
        if (g != null) {
            g.parent = f;
        }
        updateHeight(f);

        //b-d-f
        d.left = b;
        d.right = f;
        b.parent = d;
        f.parent = d;
        updateHeight(d);

    }

    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;//T1
        //发生旋转
        grand.right = child;
        parent.left = grand;

        afterRotate(grand,parent,child);
    }

    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;//T2
        //发生旋转
        grand.left = child;
        parent.right= grand;

        afterRotate(grand,parent,child);

    }

    private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child){
        //更新p属性
        //1.让p成为子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        }else if (grand.isRightChild()){
            grand.parent.right = parent;
        }else {//g是根节点
            root = parent;
        }

        //2.更新child的parent
        if (child != null) {
            child.parent = grand;
        }

        //3.更新g的parent
        grand.parent = parent;

        //4.更新高度
        updateHeight(grand);
        updateHeight(parent);

    }


    public void afterRemove(Node<E> node){//父节点 or 祖先节点中，只有一个节点可能失衡
        while ((node = node.parent) != null){//一直向上找
            if (isBalanced(node)) {//判断每个节点是否平衡
                //更新高度
                updateHeight(node);
            }else {
                rebalance(node); //！！！去掉break，因为要一路向上找，一直找到可能失衡的那个
            }
        }

    }


}
