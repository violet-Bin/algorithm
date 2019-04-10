package com.algorithm.swordoffer;

/**
 * @Author: jiangjiabin
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * 注：可以用两个指针
 * @Date: Create in 0:12 2019/4/5
 */
public class Code13FindKthToTail {

    public ListNode findKthToTail(ListNode listNode, int k) {
        if (listNode == null) {
            return null;
        }
        ListNode node = listNode;
        ListNode node1 = listNode;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
            if (count >= k) {
                node1 = node1.next;
            }
        }

        if (count > k) {
            return node1;
        } else {
            return null;
        }
//        if (count < k) {
//            return null;
//        }
//        ListNode key = listNode;
//        for (int i = 0; i < count - k; i++) {
//            key = key.next;
//        }
//        return key;
    }

}
