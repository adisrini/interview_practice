package ch3.stacksqueues.practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueViaStacksTest {
    
    private QueueViaStacks<Integer> queue;
    
    @Before
    public void setUp() {
        queue = new QueueViaStacks<>();
    }
    
    @After
    public void tearDown() {
        queue = null;
    }
    
    @Test
    public void testAdd() {
        queue.add(0);
        queue.add(1);
        queue.add(2);
        Assert.assertTrue(queue.peek() == 0);
    }
    
    @Test
    public void testRemove() {
        queue.add(0);
        queue.add(1);
        queue.add(2);
        Assert.assertTrue(queue.remove() == 0);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        Assert.assertTrue(queue.remove() == 1);
        Assert.assertTrue(queue.remove() == 2);
    }
    
    @Test
    public void testPeek() {
        queue.add(0);
        queue.add(1);
        queue.add(2);
        Assert.assertTrue(queue.peek() == 0);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        Assert.assertTrue(queue.peek() == 0);
        Assert.assertTrue(queue.peek() == 0);
    }
    
    @Test
    public void testIsEmpty() {
        queue.add(10);
        Assert.assertFalse(queue.isEmpty());
        queue.remove();
        Assert.assertTrue(queue.isEmpty());
    }

}
