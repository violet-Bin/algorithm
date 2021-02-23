package com.algorithm.question;

/**
 * @author: jiangjiabin
 * @date: Create in 20:34 2021/2/6
 * @description:
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 *
 *         1
 *      2     3
 *   4   5  6   7
 *
 * 输出：123+124+135
 */
public class TreeSum {


    public static Integer sum(TreeNode root, StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(String.valueOf(root.val));
        }

        if (root.left == null && root.right == null) {
            return Integer.parseInt(sb.toString());
        }

        StringBuilder leftVal = new StringBuilder(sb);
        StringBuilder rightVal = new StringBuilder(sb);
        Integer left = 0;
        Integer right = 0;
        if (root.left != null) {
            leftVal.append(root.left.val);
            left = sum(root.left, leftVal);
        }
        if (root.right != null) {
            rightVal.append(root.right.val);
            right = sum(root.right, rightVal);
        }

        return left + right;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(sum(root, null));
    }



}
