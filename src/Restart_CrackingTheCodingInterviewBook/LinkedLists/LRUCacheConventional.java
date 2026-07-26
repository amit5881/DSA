package Restart_CrackingTheCodingInterviewBook.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheConventional {

    public static class DoublyLinkedList {
        int key;
        int value;
        DoublyLinkedList prev;
        DoublyLinkedList next;
        public DoublyLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    private final int capacity;
    private final Map<Integer, DoublyLinkedList> hashMap;
    private final DoublyLinkedList head;
    private final DoublyLinkedList tail;

    public LRUCacheConventional(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
        this.head = new DoublyLinkedList(-1, -1);
        this.tail = new DoublyLinkedList(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void addToTail(DoublyLinkedList node) {
        DoublyLinkedList prevNode = this.tail.prev;
        node.prev = prevNode;
        node.next = tail;
        prevNode.next = node;
        tail.prev = node;
    }

    private void removeNode(DoublyLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) return -1;

        DoublyLinkedList node = hashMap.get(key);
        removeNode(node);
        addToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) removeNode(hashMap.get(key));

        DoublyLinkedList node = new DoublyLinkedList(key, value);
        hashMap.put(key, node);

        if (hashMap.size() > capacity) {
            hashMap.remove(head.next.key);
            removeNode(head.next);
        }
        addToTail(node);
    }

    public static void main(String[] args) {
        LRUCacheConventional cache = new LRUCacheConventional(3);
        cache.put(1, 100);
        cache.put(2, 250);
        System.out.println(cache.get(2));
        cache.put(4, 300);
        cache.put(3, 200);
        System.out.println(cache.get(4));
        System.out.println(cache.get(1));
    }

}
