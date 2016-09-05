package ch3.stacksqueues.implementations;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {
    
    private Queue<Integer> myQueue;
    
    @Before
    public void setUp() {
        myQueue = new Queue<>();
    }
    
    @After
    public void tearDown() {
        myQueue = null;
    }
    
    @Test
    public void testAdd() {
        myQueue.add(0);
        myQueue.add(1);
        myQueue.add(2);
        Assert.assertTrue(myQueue.first.data == 0);
        Assert.assertTrue(myQueue.last.data == 2);
    }
    
    @Test
    public void testRemove() {
        myQueue.add(0);
        myQueue.add(1);
        myQueue.add(2);
        Assert.assertTrue(myQueue.remove() == 0);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        Assert.assertTrue(myQueue.remove() == 1);
        Assert.assertTrue(myQueue.remove() == 2);
    }
    
    @Test
    public void testPeek() {
        myQueue.add(0);
        myQueue.add(1);
        myQueue.add(2);
        Assert.assertTrue(myQueue.peek() == 0);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        Assert.assertTrue(myQueue.peek() == 0);
        Assert.assertTrue(myQueue.peek() == 0);
    }
    
    @Test
    public void testIsEmpty() {
        myQueue.add(10);
        Assert.assertFalse(myQueue.isEmpty());
        myQueue.remove();
        Assert.assertTrue(myQueue.isEmpty());
    }

}
