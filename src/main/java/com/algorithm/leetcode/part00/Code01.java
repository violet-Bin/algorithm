package com.algorithm.leetcode.part00;

/**
 * @author: jiangjiabin
 * @date: Create in 22:54 2021/2/22
 * @description: 两数相加
 * 给你两个非空的链表，表示两个非负整数。
 * 他们的每位数字都按照逆序的方式存储，并且每个节点只能存储一位数字。
 * 请你将两个数字相加，并以相同形式返回一个表示和的链表。
 * 可假设除了数字0之外，这两个数都不会以0开头。
 * 示例：
 * 输入
 * 2 -> 4 -> 3
 * 5 -> 6 -> 4
 * 看成342 + 465 = 807
 * 输出：7 -> 0 -> 8
 *
 * 输入
 * 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9
 * 9 -> 9 -> 9 -> 9
 * 输出：8 9 9 9 0 0 0 1
 */
public class Code01 {

    /**
     * 解法一：将长度较短的链表在末尾补0使得
     * @param node1
     * @param node2
     * @return
     */
    public ListNode addTowNumbers(ListNode node1, ListNode node2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int x = node1 == null ? 0 : node1.val;
            int y = node2 == null ? 0 : node2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;
            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}