package com.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/19
 * @Description: LinkedHashMap实现LRU
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private LinkedHashMap<K, V> cache;
    private int cacheSize;

    public LRUCache(int cacheSize) {

        this.cacheSize = cacheSize;
        int hashTableCapacity = (int) (Math.ceil(cacheSize / 0.75)) + 1;
        cache = new LinkedHashMap<K, V>(hashTableCapacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCache.this.cacheSize;
            }
        };
    }

    public V put(K key, V value) {
        return cache.put(key, value);
    }

    public V get(Object key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(5);
        lruCache.put("a", 1);
        lruCache.put("b", 2);
        lruCache.put("c", 3);
        lruCache.put("d", 4);
        printCache(lruCache);

        System.out.println(lruCache.get("b"));
        printCache(lruCache);
        lruCache.get("a");
        lruCache.put("e", 5);
        lruCache.put("f", 6);
        printCache(lruCache);
    }

    private static void printCache(LRUCache lruCache) {
        for (Object o : lruCache.cache.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
        }
        System.out.println();
    }
}
