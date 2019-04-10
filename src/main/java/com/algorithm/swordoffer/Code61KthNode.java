package com.algorithm.swordoffer;

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
}
