package net.largem.poc.lrucachemap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheMap<K, V> extends LinkedHashMap<K, V> {

    private final int maxSize;

    public LRUCacheMap(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        System.out.println(String.format("key=%s, value=%s", eldest.getKey(), eldest.getKey()));

        return size() > maxSize;
    }

    @Override
    public V get(Object key) {
        if (containsKey(key)) {
            V v = remove(key);
            return put((K)key, v);
        }

        return null;
    }
}
