package ch1.arrays.implementations.hashtable;

public interface IHashTable<K, V> {
    
    public void put(K key, V value);
    
    public V get(K key);
    
    public boolean remove(K key);
    
    public void print();

}
