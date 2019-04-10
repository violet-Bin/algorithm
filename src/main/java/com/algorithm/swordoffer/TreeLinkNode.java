package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/10
 * @Description: 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
