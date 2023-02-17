package ca.bytetube._00_leetcode._01_list;

import ca.bytetube._03_linkedList.LinkedList;
import ca.bytetube._03_linkedList.single.SingleLinkedList;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class _203_RemoveLinkedListElements {

    public static void main(String[] args) {
        // 1 -> 2 -> 6 -> 4 -> 5 -> 6 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        printList(head);
        System.out.println("");
        ListNode newHead = removeLinkedListElements(head, 6);
        System.out.println(newHead.val);
        printList(newHead);
    }


      public static class ListNode {
          int val;
          ListNode next;

          ListNode() {}

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }


    public static ListNode removeLinkedListElements(ListNode head, int val){
        if(head == null) return null;
        ListNode current = head;
        while(current.next != null){
            if(current.next.val == val) current.next = current.next.next;
            else current = current.next;
        }
       return head.val == val? head.next : head;
    }


    private static void printList (ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }



}
