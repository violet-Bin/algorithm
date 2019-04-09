package com.algorithm.swordoffer;

import com.algorithm.coder.no1.code02.Tree;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Code37TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);

        return nLeft > nRight ? (nLeft + 1) : (nRight + 1);
    }

}
