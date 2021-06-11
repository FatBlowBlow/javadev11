package ca.bytetube._06_binaryTree;

import ca.bytetube._06_binaryTree.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;


    //number of elements
    public int size() {
        return size;
    }


    //if it is empty or not
    public boolean isEmpty() {
        return size == 0;
    }


    //clear all elements
    public void clear() {
        root = null;
        size = 0;
    }

    //树的遍历
    //1. Preorder Traversal，中-->左-->右
    //1.1 递归
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node<E> node) {
        if (node == null) return;//递归结束的条件
        System.out.print(node.element + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);

    }

    //1.2 !!!非递归，用到了stack
    public void preorderTraversalByLoop() {
        preorderTraversalByLoop(root);

    }

    private void preorderTraversalByLoop(Node<E> node) {//主逻辑
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.print(pop.element + " ");

                //有右先压右
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                //有左再压左
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }

    }


    //2.Inorder Traversal,左-->中-->右
    //2.1 递归
    public void inorderTraversal() {
        inorderTraversal(root);

    }

    private void inorderTraversal(Node<E> node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.element + " ");
        inorderTraversal(node.right);

    }

    //2.2 非递归，用到了stack
    public void inorderTraversalByLoop() {
        inorderTraversalByLoop(root);
    }

    private void inorderTraversalByLoop(Node<E> node) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;//把左树全部压入
                }else {//node = null
                    Node pop = stack.pop();
                    System.out.print(pop.element + " ");
                    node = pop.right;
                }

            }
        }

    }


    //3.Postorder Traversal，左-->右-->中
    //3.1递归
    public void postorderTraversal() {
        postorderTraversal(root);

    }

    private void postorderTraversal(Node<E> node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.element + " ");
    }

    //3.2 非递归，reverse preorder
    public void postorderTraversalByLoop() {
        postorderTraversalByLoop(root);
    }

    private void postorderTraversalByLoop(Node<E> node) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> stack1 = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {//中-->右-->左
                node = stack.pop();
                stack1.push(node);
                //有左先压左
                if (node.left != null) {
                    stack.push(node.left);
                }
                //有右再压右
                if (node.right != null) {
                    stack.push(node.right);
                }
            }

            //reverse preorder
            while (!stack1.isEmpty()) {
                System.out.print(stack1.pop().element + " ");

            }

        }


    }


    //4.Level Order Traversal
    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.element + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

        }

    }


    //传入visitor访问器,visitor pattern
    public static abstract class Visitor<E> {
        boolean stop;
        public abstract boolean visit(E element);//boolean使访问器具备一定可控性
    }

    //1.Preorder
    //1.1 recursive
    public void preorderTraversal(Visitor<E> visitor) {//传入访问器
        if (visitor == null) return;
        preorderTraversal(root, visitor);

    }

    private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
//        boolean stop = visitor.visit(node.element);
//        visitor.stop = stop;
        visitor.stop = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }



    //1.2 non-recursive
    public void preorderTraversalByLoop(Visitor<E> visitor) {
        if (visitor == null) return;
        preorderTraversalByLoop(root, visitor);
    }

    private void preorderTraversalByLoop(Node<E> node, Visitor<E> visitor) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty() && !visitor.stop) {
                Node<E> pop = stack.pop();
                visitor.stop = visitor.visit(pop.element);

                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
    }


    //2.Inorder
    //2.1 recursive
    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        inorderTraversal(node.left, visitor);
        visitor.stop = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    //2.2 non-recursive
    public void inorderTraversalByLoop(Visitor<E> visitor) {
        if (visitor == null) return;
        inorderTraversalByLoop(root, visitor);
    }

    private void inorderTraversalByLoop(Node<E> node, Visitor<E> visitor) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();

            while ((!stack.isEmpty() || node != null) && !visitor.stop) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    Node<E> pop = stack.pop();
                    visitor.stop = visitor.visit(pop.element);
                    node = pop.right;
                }
            }

        }
    }


    //3.Postorder
    //3.1 recursive
    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        postorderTraversal(root, visitor);
    }

    private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        visitor.stop = visitor.visit(node.element);
    }

    //3.2 non-recursive
    public void postorderTraversalByLoop(Visitor<E> visitor) {
        if (visitor == null) return;
        postorderTraversalByLoop(root, visitor);
    }

    private void postorderTraversalByLoop(Node<E> node, Visitor<E> visitor) {
        if (node != null) {
            Stack<Node<E>> stack = new Stack<>();
            Stack<Node<E>> stack1 = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                stack1.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }

            while (!stack1.isEmpty() && !visitor.stop) {
                visitor.stop = visitor.visit(stack1.pop().element);
            }
        }
    }


    //4.level order
    public void levelOrderTraversal(Visitor<E> visitor) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty() && !visitor.stop) {
            Node<E> node = queue.poll();
            visitor.stop = visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    //求树的高度
    //recursive
    public int height1() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));

    }

    //non-recursive --> level order
    private int height() {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        int levelSize = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {//即将访问树的下一层
                levelSize = queue.size();
                height++;
            }

        }

        return height;
    }


    //是否为complete binary tree
    public boolean isComplete() {
        return isComplete(root);
    }

    private boolean isComplete(Node<E> root) {
        if (root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (leaf && !node.isLeaf()) {//叶节点true，但不为叶节点
                return false;
            }

            if (node.hasTwoChildren()) {//1.
                queue.offer(node.left);
                queue.offer(node.right);
            }else if (node.left == null && node.right != null) {//2.
                return false;
            }else if (node.left != null && node.right == null) {//3.
                queue.offer(node.left);
                leaf = true;
            }else {//4.之后所有的节点都必须是leaf节点
                leaf = true;
            }
        }

        return true;
    }


    //前驱节点
    public Node<E> predecessor(Node<E> node) {
        if (node == null) return null;

        //1. node.left != null --> 找左子树最右边的node
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        //2. node.left == null && node.parent != null --> 向上找，直到某一节点是他父节点的右孩子，这个父节点就是前驱点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        //3. node.left == null && node.parent == null --> 没有左子树的root节点
        return node.parent;
    }

    //后继点
    public Node<E> successor(Node<E> node) {
        if (node == null) return null;

        //1. node.right != null --> 找右子树最左边的node
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        //2. node.right == null && node.parent != null
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        //3. node.right == null && node.parent == null --> 没有右子树的root节点
        return node.parent;

    }



    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        BinarySearchTree.Node<E> myNode = (BinarySearchTree.Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();

        }
//        return ((Node<E>)node).element;
        return myNode.element + "_p(" + parentString + ")";//显示parent
    }


    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;//root节点的父节点时null
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element + "}";
        }

        public boolean hasTwoChildren() {
            return this.left != null && this.right != null;
        }


        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

    }



}