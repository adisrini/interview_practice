package misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    class Node {
        int data;
        Node prev;
        Node next;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    class CapacityQueue {
        Node head;
        Node tail;
        int size;
        int capacity;
        
        CapacityQueue(int capacity) {
            this.capacity = capacity;
        }
        
        int add(Node node) {
            int value = -1;
            if(head == null && tail == null) {
                head = node;
                tail = head;
            } else {
                if(size == capacity) {
                    value = tail.data;
                    tail = tail.prev;
                    size--;
                }
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
            return value;
        }
    
        void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }
    }
    
    private CapacityQueue cache_q;
    private Map<Integer, Node> cache_ht;
    
    public LRUCache(int capacity) {
         cache_q = new CapacityQueue(capacity);
         cache_ht = new HashMap<>();
    }
    
    public int get(int key) {
        if(cache_ht.containsKey(key)) {
            return cache_ht.get(key).data;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(!cache_ht.containsKey(key)) {
            Node insert = new Node(value);
            cache_ht.put(key, insert);
            int deleted = cache_q.add(insert);
            System.out.println(key + " " + value + " " + deleted);
            if(deleted != -1) {
                cache_ht.remove(deleted);
            }
        }
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
    }
}