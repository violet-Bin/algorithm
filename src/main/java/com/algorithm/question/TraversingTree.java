package com.algorithm.question;

import java.util.Stack;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 0:35 2019/4/14
 */
public class TraversingTree {

    /**
     * 用栈先序遍历二叉树
     *
     * @param root
     */
    public void preTraverseStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            //先入右节点
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            System.out.print(node.val + " ");
        }
    }

    /**
     * 前序遍历迭代方式
     *
     * @param root
     */
    public void preTraverseIter(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preTraverseIter(root.left);
        preTraverseIter(root.right);
    }

    /**
     * 用栈中序遍历二叉树
     *
     * @param root
     */
    public void midTraverseStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");

                if (node.right != null) {
                    stack.push(node.right);
                    break;
                }
            }
        }
    }

    /**
     * 中序遍历迭代方式
     *
     * @param root
     */
    public void midTraverseIter(TreeNode root) {
        if (root == null) {
            return;
        }
        midTraverseIter(root.left);
        System.out.print(root.val + " ");
        midTraverseIter(root.right);
    }

    /**
     * 用栈后序遍历二叉树
     *
     * @param root
     */
    public void postTraverseStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        //记录上一次出栈的结点
        TreeNode lastNode = null;
        while (!stack.empty()) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            while (!stack.empty()) {
                if (lastNode == stack.peek().right || stack.peek().right == null) {
                    TreeNode node = stack.pop();
                    System.out.print(node.val + " ");
                    lastNode = node;
                } else if (stack.peek().right != null) {
                    stack.push(stack.peek().right);
                    break;
                }
            }
        }
    }

    /**
     * 后序遍历迭代方式
     *
     * @param root
     */
    public void postTraverseIter(TreeNode root) {
        if (root == null) {
            return;
        }
        postTraverseIter(root.left);
        postTraverseIter(root.right);
        System.out.print(root.val + " ");
    }


    public static void main(String[] args) {
        TreeNode root = initTree();
        TraversingTree obj = new TraversingTree();
        System.out.println("用迭代先序遍历：");
        obj.preTraverseIter(root);
        System.out.println();

        System.out.println("用栈先序遍历：");
        obj.preTraverseStack(root);
        System.out.println();

        System.out.println("用迭代中序遍历：");
        obj.midTraverseIter(root);
        System.out.println();

        System.out.println("用栈中序遍历：");
        obj.midTraverseStack(root);
        System.out.println();

        System.out.println("用迭代后序遍历：");
        obj.postTraverseIter(root);
        System.out.println();

        System.out.println("用栈后序遍历：");
        obj.postTraverseStack(root);
        System.out.println();


    }

    private static TreeNode initTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;

        return node4;
    }

}
