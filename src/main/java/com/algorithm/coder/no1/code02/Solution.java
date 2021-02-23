package com.algorithm.coder.no1.code02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jiangjiabin
 * @date: Create in 1:18 2021/2/7
 * @description:
 */
public class Solution {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        front(root);
        middle(root);
        last(root);
        int[][] result = new int[3][];
        result[0] = toIntArr(frontArr);
        result[1] = toIntArr(middleArr);
        result[2] = toIntArr(lastArr);
        return result;
    }

    private int[] toIntArr(List<Integer> arrList) {
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }

    List<Integer> frontArr = new ArrayList();
    List<Integer> middleArr = new ArrayList();
    List<Integer> lastArr = new ArrayList();
    public void front(TreeNode root) {
        if (root != null){
            frontArr.add(root.value);
            front(root.left);
            front(root.right);
        }
    }

    public void middle(TreeNode root) {
        if (root != null){
            middle(root.left);
            middleArr.add(root.value);
            middle(root.right);
        }
    }

    public void last(TreeNode root) {
        if (root != null){
            last(root.left);
            last(root.right);
            lastArr.add(root.value);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.threeOrders(root)));
    }
}

class TreeNode{
    Integer value;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer value){
        this.value = value;
    }
}
