package com.algorithm.question;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/12
 * @Description: 一个链表，奇数位升序偶数位降序，让链表变成升序的。
 * 比如：1 8 3 6 5 4 7 2 9，最后输出1 2 3 4 5 6 7 8 9。
 * 思路：
 * 1)首先根据奇数位和偶数位拆分成两个链表。
 * 2)然后对偶数链表进行反转。
 * 3)最后将两个有序链表进行合并。
 */
public class OddIncreaseEvenDecrease {

    /**
     * 按奇偶位拆分成两个链表
     *
     * @param head
     * @return
     */
    public static ListNode[] getLists(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode head1 = null;
        ListNode head2 = null;

        ListNode cur1 = null;
        ListNode cur2 = null;
        int count = 1;//用来计数
        while (head != null) {
            if (count % 2 == 1) {
                if (cur1 != null) {
                    cur1.next = head;
                    cur1 = cur1.next;
                } else {
                    cur1 = head;
                    head1 = cur1;
                }
            } else {
                if (cur2 != null) {
                    cur2.next = head;
                    cur2 = cur2.next;
                } else {
                    cur2 = head;
                    head2 = cur2;
                }
            }
            head = head.next;
            count++;
        }
        //跳出循环，让最后两个末尾元素的下一个都指向null
        cur1.next = null;
        cur2.next = null;

        ListNode[] nodes = new ListNode[]{head1, head2};
        return nodes;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode combineList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        ListNode head = head1.val < head2.val ? head1 : head2;
        //cur1始终等于第一个元素小(也可能等)的链表
        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = null;
        ListNode next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {//因此这应该加 " = "
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                //将next指向cur1,再将pre=cur2.
                // 如果下一个循环cur1.val <= cur2.val,则直接让pre = cur1;
                // 如果条件不成立,可通过pre.next = cur2改变
                cur2.next = cur1;
                pre =cur2;
                cur2 = next;
            }
        }
        //最后其中一个链表会剩一个元素
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = init();
        ListNode[] lists = getLists(head);

        ListNode head1 = lists[0];
        ListNode head2 = lists[1];
        head2 = reverseList(head2);

        head = combineList(head1, head2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode init(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }
}
