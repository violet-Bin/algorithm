package com.algorithm.swordoffer;

/**
 * @author: <a href="mailto:jiangjiabin3@jd.com">江家宾</a>
 * @date: 2019/4/10
 * @Description: 在一个排序的链表中，存在重复的结点，请
 * 删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Code55DeleteDuplicationNode {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        if (pHead.val == pHead.next.val) { //当前节点是重复的
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                //跳过与当前结点相同的全部结点，找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        } else { //当前结点不是重复的
            pHead.next = deleteDuplication(pHead.next);//保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }


}
