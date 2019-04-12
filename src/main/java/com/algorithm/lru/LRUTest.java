package com.algorithm.lru;

/**
 * @author: jiangjiabin
 * @date: 2019/4/12
 * @Description: test
 */
public class LRUTest {

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.set("a", 1);
        lru.printCache();

        lru.set("b", 2);
        lru.printCache();

        lru.set("c", 3);
        lru.printCache();

        lru.set("d", 4);
        lru.printCache();

        lru.get("b");
        lru.printCache();

        lru.set("a", 8);
        lru.printCache();
    }
}
