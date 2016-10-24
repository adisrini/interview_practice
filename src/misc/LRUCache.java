package misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    class Node {
        int key;
        int data;
        Node prev;
        Node next;
        
        Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
        
        @Override
        public String toString() {
            return String.format("(%d: %d)", key, data);
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
            int key = -1;
            if(head == null && tail == null) {
                head = node;
                tail = head;
            } else {
                if(size == capacity) {
                    key = tail.key;
                    tail = tail.prev;
                    size--;
                }
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
            return key;
        }
    
        void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            if(prev != null) {
                prev.next = next;
            }
            if(next != null) {
                next.prev = prev;
            }
            size--;
        }
        
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node curr = head;
            while(curr != null) {
                builder.append(curr.toString());
                builder.append("->");
                curr = curr.next;
            }
            return builder.toString();
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
            Node node = cache_ht.get(key);
            if(cache_q.size > 1) {
                cache_q.remove(node);
                cache_q.add(node);
            }
            return node.data;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(!cache_ht.containsKey(key) || cache_ht.get(key).data != value) {
            Node insert = new Node(key, value);
            cache_ht.put(key, insert);
            int deleted = cache_q.add(insert);
            if(deleted != -1) {
                cache_ht.remove(deleted);
            }
        }
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//        cache.set(2, 1);
////        System.out.println(cache.cache_q);
//        cache.set(2, 2);
////        System.out.println(cache.cache_q);
//        System.out.println(cache.get(2));
//        cache.set(1, 1);
////        System.out.println(cache.cache_q);
//        cache.set(4, 1);
////        System.out.println(cache.cache_q);
//        System.out.println(cache.get(2));
        System.out.println(Integer.MAX_VALUE);
    }
}