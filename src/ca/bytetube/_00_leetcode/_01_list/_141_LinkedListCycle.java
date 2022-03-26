package ca.bytetube._00_leetcode._01_list;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class _141_LinkedListCycle {

     class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
             next = null;
         }
     }


    public boolean hasCycle(ListNode head) {
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
}



