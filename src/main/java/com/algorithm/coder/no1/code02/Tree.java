package com.algorithm.coder.no1.code02;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @Author: jiangjiabin
 * @Description: 二叉树类
 * @Date: Create in 9:11 2019/2/27
 */
public class Tree {

    //根节点
    public Node root;

    /**
     * 插入节点
     */
    public void insert(int value, String sValue) {
        //封装节点
        Node newNode = new Node(value, sValue);
        //引用当前节点
        Node current = root;
        //引用父节点
        Node parent;
        //如果root为null, 也就是第一个插入的时候
        if (root == null) {
            root = newNode;
            return;
        } else {
            while (true) {
                //父节点指向当前节点
                parent = current;
                //如果当前指向的节点数据比插入的要大
                if (current.data > value) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找节点
     */
    public Node find(int value) {
        //引用当前节点, 从根节点开始
        Node current = root;
        //循环,只要查找值不等于当前节点的数据项
        while (current.data != value) {
            //进行比较,比较查找值和当前节点的大小
            if (current.data > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            //如果找不到
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 删除节点
     */
    public boolean delete(int value) {
        //引用当前节点,从根节点开始
        Node current = root;

        //引用当前节点的父节点
        Node parent = root;
        //是否为左节点
        boolean isLeftChild = true;

        while (current.data != value) {
            parent = current;
            //进行比较,比较查找值和当前节点的大小
            if (current.data > value) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            //如果找不到
            if (current == null) {
                return false;
            }
        }

        //删除叶子节点, 也就是该节点没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {//如果他是父节点的左子节点
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessscor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     * 获得中序后继遍历
     */
    public Node getSuccessscor(Node delNode) {
        Node successor = delNode;
        Node successorParent = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }


    /**
     * 前序遍历
     */
    public void frontOrder(Node localNode) {
        if (localNode != null) {
            //访问根节点
            System.out.println(localNode.data + "," + localNode.sData);
            //前序遍历左子树
            frontOrder(localNode.leftChild);
            //前序遍历左子树
            frontOrder(localNode.rightChild);
        }
    }

    /**
     * 中序遍历
     * 中序遍历是有序的
     */
    public void inOrder(Node localNode) {
        if (localNode != null) {
            //中序遍历左子树
            inOrder(localNode.leftChild);
            //中序遍历根节点
            System.out.println(localNode.data + "," + localNode.sData);
            //中序遍历右子节点
            inOrder(localNode.rightChild);
        }
    }

    /**
     * 后序遍历
     */
    public void lastOrder(Node localNode) {
        if (localNode != null) {
            //后序遍历左子树
            lastOrder(localNode.leftChild);
            //后序遍历根节点
            lastOrder(localNode.rightChild);
            //后序遍历右子节点
            System.out.println(localNode.data + "," + localNode.sData);
        }
    }

    /**
     * 获得二叉树的深度
     *
     * @param node
     * @return
     */
    public int getTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = getTreeDepth(node.leftChild);
        int right = getTreeDepth(node.rightChild);

        return left >= right ? left + 1 : right + 1;
    }

    /**
     * 获得二叉树的宽度
     *
     * @param node
     * @return
     */
    public int getTreeWidth(Node node) {
        if (node == null)
            return 0;

        Queue<Node> queue = new ArrayDeque<>();
        int maxWidth = 1; // 最大宽度
        queue.add(node); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                Node t = queue.poll();
                len--;
                if (t.leftChild != null)
                    queue.add(t.leftChild); // 下一层节点入队
                if (t.rightChild != null)
                    queue.add(t.rightChild);// 下一层节点入队
            }
            maxWidth = Math.max(maxWidth, queue.size());
        }
        return maxWidth;
    }
    private int[] toIntArr(List<Integer> arrList) {
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }

}
