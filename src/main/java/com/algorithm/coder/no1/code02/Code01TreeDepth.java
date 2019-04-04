package com.algorithm.coder.no1.code02;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 9:04 2019/2/27
 */
public class Code01TreeDepth {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20, "a");
        tree.insert(15, "b");
        tree.insert(25, "v");
        tree.insert(8, "d");
        tree.insert(17, "e");
        tree.insert(22, "f");
        tree.insert(28, "g");
        tree.insert(26, "g");
        tree.insert(27, "g");

        int treeDepth = tree.getTreeDepth(tree.root);
        System.out.println(treeDepth);
        System.out.println(tree.getTreeWidth(tree.root));
    }



}
