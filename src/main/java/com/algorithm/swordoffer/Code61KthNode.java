package com.algorithm.swordoffer;

import java.util.Stack;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/10
 * @Description: 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 注：中序遍历
 */
public class Code61KthNode {

    private int k;

    public TreeNode KthNode(TreeNode root, int k) {
        this.k = k;
        return helper(root);
    }

    private TreeNode helper(TreeNode root) {
        TreeNode temp;
        if (root != null) {
            if ((temp = helper(root.left)) != null) return temp;
            if (--k == 0) return root;
            if ((temp = helper(root.right)) != null) return temp;

        }
        return null;
    }

    /**
     * 非递归中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public TreeNode KthNode2(TreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                count++;
                if (count == k) {
                    return node;
                }
                node = node.right;
            }
        }
        return null;
    }
}
