package Restart_CrackingTheCodingInterviewBook.LinkedLists;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheModern<K, V> extends LinkedHashMap<K, V> {
    int capacity;
    public LRUCacheModern(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > capacity;
    }

    public int get(int key) {
        V value = super.get(key);
        return value == null ? -1 : (int) value;
    }

    public V put(K key, V value) {
        super.put(key, value);
        return value;
    }

    public static void main(String[] args) {
        LRUCacheModern<Integer, Integer> cache = new LRUCacheModern(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1

        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1

        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
