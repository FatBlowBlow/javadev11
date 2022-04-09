package ca.bytetube._00_leetcode._01_list;


public class _interview_list {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 找到2个单链表的相交节点
     *
     * 判断2个单链表是否含环:
     *
     * 1. 无环 ---> return null:
     *    不相交
     *    2个无环单链表的相交,只有一种可能:Y型
     *
     * 2. 有环 ---> 找出入环节点
     *    不相交
     *    2个有环单链表的相交,有两种可能: 1.共用一个环 2.不共用一个环
     *
     * 3. 1个无环单链表和1个有环单链表是不可能相交的
     */
    public static ListNode getIntersectNode(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null) return null;
        //获取各自的入环节点
        ListNode loop1 = hasCircle(head1);
        ListNode loop2 = hasCircle(head2);
        //1. 2个无环单链表的相交
        if (loop1 == null && loop2 == null) return noCircle(head1, head2);

        //2. 2个有环单链表的相交
        if (loop1 != null && loop2 != null) return twoCircle(head1, loop1, head2, loop2);

        //3. 1个无环单链表和1个有环单链表是不可能相交的
        return null;
    }

    /**
     * 1.判断链表是否含环(快慢指针):
     * 不含环 ---> return null
     * 含环 ---> 找出入环节点
     */
    public static ListNode hasCircle(ListNode head){
        if (head == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while(slow != fast){
            if (fast.next == null || fast.next.next == null) return null;//不含环,return null
            slow = slow.next;
            fast = fast.next.next;
        }
        //将快指针拉回到开头，并只走一步，下一次快慢指针重合时就是入环节点
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;//含环,return 入环节点
    }

    /**
     * 2个不含环的单链表的相交节点
     */
    public static ListNode noCircle(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null) return null;
        //1.先统计2个链表的长度（长度差）
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0;//长度差
        while (cur1.next != null){//cur1跑到尾节点, 得到size --> n
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2 = cur2.next;//cur2跑到尾节点
        }
        if (cur1 != cur2) return null;//2个不含环的单链表不相交,return null

       cur1 = n > 0 ? head1 : head2;//cur1永远跑长的
       cur2 = cur1 == head1 ? head2 : head1;
//        if (n > 0) {
//            cur1 = head1;
//            cur2 = head2;
//        }else{
//            cur1 = head2;
//            cur2 = head1;
//        }
        n = Math.abs(n);
        //先让长链表把长的部分跑完
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        //让2个链表指针同时跑,相遇时即相交节点
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;//2个不含环的单链表相交,return 相交节点
    }


    /**
     * 2个含环的单链表的相交节点
     * loop1:list1 入环节点
     * loop2:list2 入环节点
     */
    public static ListNode twoCircle(ListNode head1, ListNode loop1, ListNode head2,ListNode loop2){
        if (head1 == null || head2 == null) return null;
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 == loop2) {//I:相交并且共用同一个环 ---> 入环节点相同
            cur1 = head1;
            cur2 = head2;
            int n = 0;//长度差
            while (cur1.next != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;//cur1永远跑长的
            cur2 = cur1 == head1 ? head2 : head1;//cur2永远跑短的
            n = Math.abs(n);
            //先让长链表把长的部分跑完
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            //让2个链表指针同时跑,相遇时即相交节点
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;//相交节点

        }else {//II:相交但不共用一个环
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2) return loop1;
                cur1 = cur1.next;
            }
        }
        return null;//II:不相交
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
        //1个不含环的单链表
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        //  0 -> 9 -> 8 -> 6 -> 7 -> null
        //1个不含环的单链表
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next;//8 -> 6
        //System.out.println(getIntersectNode(head1,head2).val);

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 4....
        //1个含环的单链表
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next;//7 -> 4


        //  0 -> 9 -> 8 -> 2...
        //另一个含共同环的单链表
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next;//8 -> 2
        System.out.println(getIntersectNode(head1,head2).val);


        //  0 -> 9 -> 8 -> 6 -> 4 -> 5 -> 6...
        //2个含环的单链表 （不共用一个环）
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next;//8 -> 6
        //System.out.println(getIntersectNode(head1,head2).val);

    }

}
