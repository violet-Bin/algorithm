package com.algorithm.lru;

import org.omg.CORBA.StringHolder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/12
 * @Description: LRU HashMap+双向链表实现
 * 核心操作步骤：
 * 1）save(key, value)，首先在 HashMap 找到 Key 对应的节点，如果节点存在，更新节点的值，
 * 并把这个节点移动队头。如果不存在，需要构造新的节点，并且尝试把节点塞到队头，
 * 如果LRU空间不足，则通过 tail 淘汰掉队尾的节点，同时在 HashMap 中移除 Key。
 * 2）get(key)，通过 HashMap 找到 LRU 链表节点，因为根据LRU原理，
 * 这个节点是最新访问的，所以要把节点插入到队头，然后返回缓存的值。
 */
public class LRU {

    private HashMap<String, DLinkedList> cache = new HashMap<>();

    /**
     * 已缓存的数量
     */
    private int count;

    /**
     * 共可缓存的容量
     */
    private int capacity;

    /**
     * 链表头
     */
    private DLinkedList head;

    /**
     * 链表尾
     */
    private DLinkedList tail;

    public LRU(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedList();
        head.pre = null;
        head.key = "head";
        head.value = -1;
        tail = new DLinkedList();
        tail.next = null;
        tail.key = "tail";
        tail.value = -1;

        head.next = tail;
        tail.pre = head;

    }

    public void set(String key, int value) {
        DLinkedList node = cache.get(key);
        if (node == null) {
            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            count++;

            if (count > capacity) {
                DLinkedList lastNode = popLast();
                cache.remove(lastNode.key);
                count--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public int get(String key) {
        DLinkedList node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void addNode(DLinkedList newNode) {
        newNode.pre = head;
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
    }

    private DLinkedList popLast() {
        DLinkedList lastNode = tail.pre;
        removeNode(lastNode);
        return lastNode;
    }

    private void removeNode(DLinkedList lastNode) {
        DLinkedList pre = lastNode.pre;
        DLinkedList next = lastNode.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addNode(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLinkedList node = head;
        while (node != null) {
            sb.append(String.format("%s:%s", node.key, node.value)).append("   ");
            node = node.next;
        }
        return sb.toString();
    }

    public void printCache() {
        System.out.println(this.toString());
    }
}
