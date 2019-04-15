package com.algorithm.question;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/15
 * @Description: 插入二叉树结点
 */
public class InsertBinaryTreeNode {

    /**
     * 插入节点
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertNode(TreeNode root, int val) {
        //创建新节点
        TreeNode node = new TreeNode(val);
        //如果根节点是空的，就让根指向新创建的结点
        if (root == null) {
            root = node;
            return root;
        } else {
            TreeNode curNode = root;
            while (true) {
                TreeNode parentNode = curNode;
                if (curNode.val > val) {
                    curNode = curNode.left;
                    if (curNode == null) {
                        parentNode.left = node;
                        return root;
                    }
                } else {
                    curNode = curNode.right;
                    if (curNode == null) {
                        parentNode.right = node;
                        return root;
                    }
                }
            }
        }
    }

    /**
     * 只返回插入的位置
     *
     * @param root
     * @param val
     * @return
     */
    public int insertNodeReturnI(TreeNode root, int val) {
        //创建新节点
        TreeNode node = new TreeNode(val);
        //记录插入的位置
        int i = 0;
        //如果根节点是空的，就让根指向新创建的结点
        if (root == null) {
            return 0;
        } else {
            TreeNode curNode = root;
            while (true) {
                TreeNode parentNode = curNode;
                if (curNode.val > val) {
                    curNode = curNode.left;
                    i = 2 * i + 1;
                    if (curNode == null) {
                        return i;
                    }
                } else {
                    curNode = curNode.right;
                    i = 2 * i + 2;
                    if (curNode == null) {
                        parentNode.right = node;
                        return i;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        /*测试insertNode
//        TreeNode root = new TreeNode(8);
        TreeNode root = null;
        InsertBinaryTreeNode obj = new InsertBinaryTreeNode();
        root = obj.insertNode(root, 8);
        root = obj.insertNode(root, 4);
        root = obj.insertNode(root, 12);
        root = obj.insertNode(root, 2);
        root = obj.insertNode(root, 15);

        TraversingTree traverse = new TraversingTree();
        traverse.preTraverseIter(root);
        */

        TreeNode root = new TreeNode(8);
//        TreeNode root = null;
        InsertBinaryTreeNode obj = new InsertBinaryTreeNode();
//        int i = obj.insertNodeReturnI(root, 8);
//        System.out.println(i);
        root = obj.insertNode(root, 4);
        root = obj.insertNode(root, 12);
        root = obj.insertNode(root, 2);

        int i = obj.insertNodeReturnI(root, 15);
        System.out.println(i);
    }
}
