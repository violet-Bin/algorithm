package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 输入两个链表，找出它们的第一个公共结点。
 */
public class Code35FindFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead1 == null) {
            return null;
        }

        int count1 = 0;
        int count2 = 0;

        ListNode p1 = pHead1;
        while (p1 != null) {
            p1 = p1.next;
            count1++;
        }

        ListNode p2 = pHead2;
        while (p2 != null) {
            p2 = p2.next;
            count2++;
        }

        int flag = count1 - count2;
        if (flag > 0) {//说明pHead1比pHead2长，让pHead先走flag长度
            while (flag > 0) {
                pHead1 = pHead1.next;
                flag--;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
        if (flag <= 0) {
            while (flag < 0) {
                pHead2 = pHead2.next;
                flag++;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
        return null;
    }
}
