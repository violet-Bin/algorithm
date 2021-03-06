package com.algorithm.swordoffer;

import java.util.Stack;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/8
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 解题思路：
 * 1.将左子树构造成双链表，并返回链表头节点。
 * 2.定位至左子树双链表最后一个节点。
 * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
 * 4.将右子树构造成双链表，并返回链表头节点。
 * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
 * 6.根据左子树链表是否为空确定返回的节点。
 */
public class Code25Tree2DoubleLinkedList {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public TreeNode convert(TreeNode root) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left != null ? left : root;
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     * @Description: 解题思路：
     * 1.核心是中序遍历的非递归算法。
     * 2.修改当前遍历节点与前一遍历节点的指针指向。
     * 需要记录一个pre指针即可.
     */
    public TreeNode convert2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        //用于保存中序遍历序列上的上一结点
        TreeNode pre = null;
        boolean isFirst = true;//用于判断是否为中序遍历的第一个节点
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (isFirst) {
                root = p;//中序遍历的第一个节点记为root
                pre = root;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }
}
