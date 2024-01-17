package ca.bytetube._00_leetcode._02_stack;

import ca.bytetube._03_linkedList.List;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */

public class _234_IsPalindrome {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        System.out.println(IsPalindrome2(head));;

    }

    //空间:O(n)
    public static boolean IsPalindrome(ListNode head){
        if (head == null || head.next == null)  return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        //匹配
        while (head != null){
            if (head.val != stack.pop().val) return false;
            head = head.next;
        }
        return true;
    }

    //空间:O(n/2)
    public static boolean IsPalindrome2(ListNode head){
        if (head == null || head.next == null)  return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head.next;
        ListNode fast = head;
        //通过快慢指针的走法，slow一定走到中间
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //把后半部分的节点装入stack
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        //比较
        while (!stack.isEmpty()){
            if (head.val != stack.pop().val) return false;
            head = head.next;
        }
        return true;
    }


    /**
     * 空间:O(1)
     * 时间:O(n)
     * 1. 通过设置快慢指针的方式找到中间节点
     * 2. 翻转右半部分
     * 3. 分别让左右指针向中间靠近，进行回文判断
     * 4. 恢复原来的List，再次翻转右半部分
     */
    public static boolean IsPalindrome3(ListNode head){
        if (head == null || head.next == null)  return true;
        //0. 如果是两个节点的list
        if (head.next.next == null) return head.val == head.next.val;
        //1. 通过设置快慢指针的方式找到中间节点
        ListNode midNode = getMidNode(head);
        //2. 翻转右半部分
        ListNode rHead = reverseList(midNode);//为什么midNode.next
        //3. 分别让左右指针向中间靠近，进行回文判断
        ListNode lHead = head;
        ListNode rOldHead = rHead;
        boolean res = true;
        while(rHead != null){//为什么lHead != null，空指针异常 --> 与取mid的位置，reverse list有关
            if (lHead.val != rHead.val){//如果直接return false的话，链表没有复原
                res = false;
                break;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }
        //4. 恢复原来的List，再次翻转右半部分
        reverseList(rOldHead);
        return res;
    }

    private static ListNode getMidNode(ListNode head) {
        ListNode slow = head.next;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
