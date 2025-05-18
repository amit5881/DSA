package ByteByteGo.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static class DoublyLinkedList {
        int key;
        int value;
        DoublyLinkedList prev;
        DoublyLinkedList next;
        public DoublyLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }
    }

    private final int capacity;
    private final Map<Integer, DoublyLinkedList> map;
    private final DoublyLinkedList head;
    private final DoublyLinkedList tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new DoublyLinkedList(-1, -1);
        this.tail = new DoublyLinkedList(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        DoublyLinkedList node = map.get(key);
        removeNode(node);
        addNodeToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }

        DoublyLinkedList node = new DoublyLinkedList(key, value);
        map.put(key, node);

        if (map.size() > capacity) {
            map.remove(this.head.next.key);
            removeNode(this.head.next);
        }

        addNodeToTail(node);
    }

    private void addNodeToTail(DoublyLinkedList node) {
        DoublyLinkedList prevNode = this.tail.prev;

        node.prev = prevNode;
        node.next = this.tail;

        prevNode.next = node;
        this.tail.prev = node;
    }

    private void removeNode(DoublyLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Driver
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1

        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }

}
