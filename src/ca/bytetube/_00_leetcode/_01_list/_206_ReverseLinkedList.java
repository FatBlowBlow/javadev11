package ca.bytetube._00_leetcode._01_list;


/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class _206_ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

        /**
         * 链表的返回值:返回的是头节点
         * 5,4,3,2,1 --> 1,2,3,4,5
         */
        //recursive
        public ListNode reverseList(ListNode head) {//返回值ListNode：新LinkedList的头节点
            if (head == null || head.next == null) return head;
            ListNode newHead = reverseList(head.next);//1
            head.next.next = head;//4 ---> 5
            head.next = null;
            return newHead;
        }

        //non-recursive
        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode newHead = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = newHead;
                newHead = head;
                head = nextNode;
            }
            return newHead;
        }
}
