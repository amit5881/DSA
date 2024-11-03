package Dump;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        System.out.println(lruCache);

        lruCache.get(1);
        lruCache.put(4, "four");

        System.out.println(lruCache);
    }
}
