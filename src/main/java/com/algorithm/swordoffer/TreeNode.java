package com.algorithm.swordoffer;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 0:16 2019/4/5
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
