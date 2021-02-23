package com.algorithm.lru;

import java.util.HashMap;

/**
 * @author: jiangjiabin
 * @date: Create in 0:30 2021/2/7
 * @description:
 */
public class Solution {

    private HashMap<String, DLinkedNode> cache = new HashMap();
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;

    public Solution() {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.key = "head";
        head.value = -1;
        tail.key = "tail";
        tail.value = -1;
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        int[] result = new int[operators.length];
        int No = 0;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].length == 3) {
                //set
                String key = String.valueOf(operators[i][1]);
                Integer value = operators[i][2];
                set(key, value, k);
            } else {
                //get
                String key = String.valueOf(operators[i][1]);
                Integer value = get(key);
                result[No++] = value;
            }
        }

        return result;
    }

    private void set(String key, Integer value, Integer k) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if (size > k) {
                DLinkedNode delNode = deleteTail();
                cache.remove(delNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private Integer get(String key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        deleteNode(node);
        addNode(node);
    }

    private void addNode(DLinkedNode newNode) {
        DLinkedNode next = head.next;
        head.next = newNode;
        newNode.pre = head;
        newNode.next = next;
        next.pre = newNode;
    }

    private void deleteNode(DLinkedNode delNode) {
        DLinkedNode pre = delNode.pre;
        DLinkedNode next = delNode.next;
        pre.next = next;
        next.pre = pre;
    }

    private DLinkedNode deleteTail() {
        DLinkedNode delNode = tail.pre;
        deleteNode(delNode);
        return delNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.set("a", 1, 3);
        solution.printCache();

        solution.set("b", 2, 3);
        solution.printCache();

        solution.set("c", 3, 3);
        solution.printCache();

        solution.set("d", 4, 3);
        solution.printCache();

        solution.get("b");
        solution.printCache();

        solution.set("a", 8, 3);
        solution.printCache();

    }

    public void printCache() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLinkedNode node = head;
        while (node != null) {
            sb.append(String.format("%s:%s", node.key, node.value)).append("   ");
            node = node.next;
        }
        return sb.toString();
    }
}

class DLinkedNode {
    String key;
    Integer value;
    DLinkedNode pre;
    DLinkedNode next;

    public DLinkedNode(){

    }

    public DLinkedNode(String key, Integer value){
        this.key = key;
        this.value = value;
    }
}
