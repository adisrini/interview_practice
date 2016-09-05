package ch1.arrays.implementations.hashtable;

import java.lang.reflect.Array;

import ch1.arrays.implementations.linkedlist.ILinkedList;
import ch1.arrays.implementations.linkedlist.LinkedList;
import ch1.arrays.implementations.linkedlist.Node;

/**
 * An implementation of a hash table. This data structure provides O(n) space complexity, and highly efficient
 * lookup, insertion, and deletion time of O(1).
 * 
 * @author Aditya Srinivasan
 * @param <K>
 *
 */
public class HashTable<K, V> implements IHashTable<K, V> {
    
    private static final int DEFAULT_CAPACITY = 100;
    
    private int capacity;
    private ILinkedList<KeyValue<K, V>>[] table;
    
    public HashTable() {
        this(DEFAULT_CAPACITY);
    }
    
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = (ILinkedList<KeyValue<K, V>>[]) Array.newInstance(LinkedList.class, capacity);
    }

    @Override
    public void put(K key, V value) {
        int index = hashcode(key) % capacity;
        if(table[index] == null) {
            table[index] = new LinkedList<KeyValue<K, V>>(new Node<KeyValue<K, V>>(null, new KeyValue<K, V>(key, value)));
            return;
        }
        table[index].add(new KeyValue<K, V>(key, value));
    }

    @Override
    public V get(K key) {
        int index = hashcode(key) % capacity;
        if(table[index] == null || table[index].get(new KeyValue<K, V>(key, null)) == null) {
            return null;
        } else {
            return table[index].get(new KeyValue<K, V>(key, null)).getValue();
        }
    }

    @Override
    public boolean remove(K key) {
        int index = hashcode(key) % capacity;
        return table[index].delete(new KeyValue<K, V>(key, null));
    }
    
    private int hashcode(K key) {
        return key.hashCode();
    }
    
    @Override
    public void print() {
        int i = 0;
        for(ILinkedList<KeyValue<K, V>> list : table) {
            if(list != null) {
                System.out.print(String.format("[%4d] ", i));
                list.print();
                System.out.println();
            }
            i++;
        }
    }

}
