package ch1.arrays.implementations.arraylist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
    
    private ArrayList<String> list;
    
    @Before
    public void setUp() {
        list = new ArrayList<String>(10);
    }
    
    @After
    public void tearDown() {
        list = null;
    }
    
    @Test
    public void testAdd() {
        list.add("A");
        Assert.assertTrue(list.size() == 1);
    }
    
    @Test
    public void testGet() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        Assert.assertTrue(list.get(0).equals("A"));
        Assert.assertTrue(list.get(1).equals("B"));
        Assert.assertTrue(list.get(2).equals("C"));
        Assert.assertTrue(list.get(3).equals("D"));
    }
    
    @Test
    public void testDelete() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        Assert.assertTrue(list.get(0).equals("A"));
        Assert.assertTrue(list.size() == 4);
        list.remove(0);
        Assert.assertTrue(list.get(0).equals("B"));
        Assert.assertTrue(list.size() == 3);
    }
    
    @Test
    public void testExpand() {
        for(int i = 0; i < 10; i++) {
            list.add(Integer.toString(i));
        }
        Assert.assertTrue(list.size() == 10);
        list.add("this one will expand the array");
        Assert.assertTrue(list.size() == 11);
    }

}
