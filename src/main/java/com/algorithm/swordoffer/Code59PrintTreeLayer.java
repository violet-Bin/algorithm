package com.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/10
 * @Description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Code59PrintTreeLayer {

    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) {
            return;
        }
        if (depth > list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(depth - 1).add(root.val);
        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }

    public ArrayList<ArrayList<Integer> > print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if(pRoot == null) {
            return ret;
        }
        q.add(pRoot);
        int now = 1, next = 0;
        while (!q.isEmpty()) {
            TreeNode t = q.remove();
            now--;
            tmp.add(t.val);
            if (t.left != null) {
                q.add(t.left);
                next++;
            }
            if (t.right != null) {
                q.add(t.right);
                next++;
            }
            if (now == 0) {
                ret.add(new ArrayList<>(tmp));
                tmp.clear();
                now = next;
                next = 0;
            }
        }
        return ret;
    }

}
