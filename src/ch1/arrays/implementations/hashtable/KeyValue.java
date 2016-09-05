package ch1.arrays.implementations.hashtable;

public class KeyValue<K, V> {
    
    private K key;
    private V value;
    
    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return this.key;
    }
    
    public V getValue() {
        return this.value;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object other) {
        if(other instanceof KeyValue) {
            return key.equals(((KeyValue<K, V>) other).getKey());
        }
        return this.equals(other);
    }
    
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

}
