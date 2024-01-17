package ca.bytetube._00_leetcode._01_list;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */

public class _876_MiddleOfLinkedList {



      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


      public ListNode middleNode2(ListNode head) {
          if (head == null || head.next == null) return head;
          if (head.next.next == null) return head.next;
          int count = 0;
          ListNode cur = head;
          while(cur.next != null) {//求size
              count++;
              cur = cur.next;
          }
          count = count / 2 == 0 ? (count >> 1) : ((count + 1) >> 1);
          for (int i = 0; i < count; i++) head = head.next;
          return head;
      }

}
