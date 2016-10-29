package ch1.arrays.implementations.hashtable;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
    
    private HashTable<String, Integer> table;
    
    @Before
    public void setUp() {
        table = new HashTable<String, Integer>(10);
    }
    
    @After
    public void tearDown() {
        table = null;
    }
    
    @Test
    public void testAdd() {
        table.put("A", 1);
        table.put("abcde", 2);
        table.print();
    }
    
    @Test
    public void testGet() {
        table.put("A", 1);
        table.put("abcde", 2);
        Assert.assertTrue(1 == table.get("A"));
        Assert.assertTrue(2 == table.get("abcde"));
    }
    
    @Test
    public void testGetNull() {
        table.put("A", 1);
        Assert.assertTrue(null == table.get("abcde"));
    }
    
    @Test
    public void testRemove() {
        table.put("A", 1);
        table.put("abcde", 2);
        table.remove("A");
        table.print();
    }

}
