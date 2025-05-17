package LinkedLists;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > capacity;
    }

    public Integer get(Integer key) {
        V value = super.get(key);
        return value == null ? -1 : (Integer) value;
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashMap<Integer, Integer> cache = new LRUCacheLinkedHashMap<>(2);

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
