package ca.bytetube._00_leetcode._01_list;

import ca.bytetube._03_linkedList.List;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class _141_LinkedListCycle {

     static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
          val = x;
          next = null;
      }
     }


    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
         ListNode fast = head.next;
         ListNode slow = head;

         while (fast != null && fast.next != null){//判断跑得快的
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) {//address ---> same node
                 return true;
             }
         }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = head.next.next.next;
        System.out.println(hasCycle(head));
    }
}



