package com.algorithm.swordoffer;

import com.alibaba.fastjson.JSON;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Code03ReConstructBinaryTree {

    private static int index = -1;
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }

        return build(pre, in, 0, in.length - 1);
    }

    private static TreeNode build(int[] pre, int[] in, int left, int right) {
        if (left > right) {
            return null;
        }
        ++index;
        TreeNode root = new TreeNode(pre[index]);//根

        int i;
        for (i = left; i <= right; i++) {
            if (pre[index] == in[i]) { //找到中序遍历的根的位子i
                break;
            }
        }

        TreeNode leftNode = build(pre, in, left, i -1); //左子树
        TreeNode rightNode = build(pre, in, i + 1, right); //右子树
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode.toString());
        System.out.println(JSON.toJSONString(treeNode));
    }
}

