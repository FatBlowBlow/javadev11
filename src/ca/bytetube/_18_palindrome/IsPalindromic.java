package ca.bytetube._18_palindrome;

import java.util.Stack;

public class IsPalindromic {
    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(2);
//        Node node3 = new Node(1);
//        Node node4 = new Node(2);
//        Node node5 = new Node(3);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        System.out.println(isPalindromic(node1));


    }


    private static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }


    //stack  space:0(n)  time:0(n)
    public static boolean isPalindromic1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null){//所有元素放入stack中
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }



    //stack 优化 快慢指针, 将最后一半放入stack中，space:0(n/2)  time:0(n)
    public static boolean isPalindromic(Node head){
        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next != null){//快指针一次走两步，需要判断两次
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
