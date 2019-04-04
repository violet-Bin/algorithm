package com.algorithm.swordoffer;

/**
 * @Author: jiangjiabin
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 * 1 -> 2 -> 3 -> 4
 * 1 <- 2 <- 3 <- 4
 * @Date: Create in 0:44 2019/4/5
 */
public class Code14ReverseList {

    public ListNode ReverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
