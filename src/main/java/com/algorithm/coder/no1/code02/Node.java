package com.algorithm.coder.no1.code02;

/**
 * @Author: jiangjiabin
 * @Description: 二叉树节点
 * @Date: Create in 9:10 2019/2/27
 */
public class Node {

    //数据项
    public int data;
    public String sData;
    //左子节点
    public Node leftChild;
    //右子节点
    public Node rightChild;

    public Node(int data, String sData) {
        this.data = data;
        this.sData = sData;
    }
}
