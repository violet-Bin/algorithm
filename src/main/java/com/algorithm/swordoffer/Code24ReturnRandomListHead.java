package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/8
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Code24ReturnRandomListHead {

    public RandomListNode clone(RandomListNode pHead){
        if (pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;
        //复制next, 如原来是A -> B -> C, 变成 A -> A' -> B -> B' -> C -> C'
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            cloneNode.next = currentNode.next;
            currentNode.next = cloneNode;
            currentNode = cloneNode.next;
        }
        currentNode = pHead;
        //复制random  currentNode是原来链表的节点, currentNode.next是复制currentNode的节点
        while (currentNode != null) {
            if (currentNode.random != null) {
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        currentNode = pHead;
        //拆分链表
        while (currentNode != null) {
            currentNode.next = currentNode.next.next;
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            currentNode = currentNode.next;
        }
        return head;
    }
}
