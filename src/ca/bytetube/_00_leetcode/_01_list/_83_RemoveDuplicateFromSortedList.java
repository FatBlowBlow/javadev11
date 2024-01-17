package ca.bytetube._00_leetcode._01_list;

import java.util.HashSet;

public class _83_RemoveDuplicateFromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);

        printList(head);
        System.out.println("");
    }


    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
            HashSet<Integer> set = new HashSet<>();
            ListNode cur = head;
            while (cur.next != null){
                if (set.contains(cur.next.val)) cur.next = cur.next.next;
                else {
                    set.add(cur.next.val);
                    cur = cur.next;
                }
            }
             if(set.contains(head.val)) head = head.next;
            return head;
    }





    private static void printList (ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
