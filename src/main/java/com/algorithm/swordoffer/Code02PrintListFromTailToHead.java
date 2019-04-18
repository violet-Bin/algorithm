package com.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 入栈 -> 出栈
 */
public class Code02PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }

        return list;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        Code02PrintListFromTailToHead obj = new Code02PrintListFromTailToHead();
        ArrayList<Integer> list = obj.printListFromTailToHead(listNode1);
        System.out.println(list);
    }
}

