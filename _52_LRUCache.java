// Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:

// set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item.
// get(key): gets the value at key. If no such key exists, return null.
// Each operation should run in O(1) time.


import java.util.*;

public class _52_LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList order;

    // Node class to represent each cache entry
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly Linked List to maintain the order of usage (most recent at head, least recent at tail)
    private static class DoublyLinkedList {
        private Node head, tail;

        DoublyLinkedList() {
            head = new Node(0, 0);  // dummy node
            tail = new Node(0, 0);  // dummy node
            head.next = tail;
            tail.prev = head;
        }

        // Add node to the front (most recently used)
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Remove a node from the list
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Remove the last node (least recently used)
        Node removeLast() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    // Constructor to initialize the LRU Cache with a given capacity
    public _52_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new DoublyLinkedList();
    }

    // Set a key-value pair in the cache
    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            // Remove the old node and update it
            Node node = cache.get(key);
            order.remove(node);
            node.value = value;
            order.addFirst(node);
        } else {
            if (cache.size() >= capacity) {
                // Remove the least recently used item
                Node last = order.removeLast();
                if (last != null) {
                    cache.remove(last.key);
                }
            }
            // Add the new key-value pair
            Node newNode = new Node(key, value);
            order.addFirst(newNode);
            cache.put(key, newNode);
        }
    }

    // Get the value of a key from the cache
    public Integer get(int key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        // Move the accessed node to the front (most recently used)
        Node node = cache.get(key);
        order.remove(node);
        order.addFirst(node);
        return node.value;
    }
    
    public static void main(String[] args) {
        // Example usage
        _52_LRUCache cache = new _52_LRUCache(3);
        cache.set(1, 1);  // Cache is {1=1}
        cache.set(2, 2);  // Cache is {1=1, 2=2}
        cache.set(3, 3);  // Cache is {1=1, 2=2, 3=3}
        System.out.println(cache.get(1));  // Returns 1, Cache is {2=2, 3=3, 1=1}
        cache.set(4, 4);  // Evicts key 2, Cache is {3=3, 1=1, 4=4}
        System.out.println(cache.get(2));  // Returns null (not found)
        System.out.println(cache.get(3));  // Returns 3, Cache is {1=1, 4=4, 3=3}
    }
}
