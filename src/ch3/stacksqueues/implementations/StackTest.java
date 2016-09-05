package ch3.stacksqueues.implementations;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    
    private Stack<Integer> myStack;
    
    @Before
    public void setUp() {
        myStack = new Stack<>();
    }
    
    @After
    public void tearDown() {
        myStack = null;
    }
    
    @Test
    public void testPush() {
        myStack.push(3);
        Assert.assertTrue(myStack.top.data == 3);
    }
    
    @Test
    public void testPop() {
        myStack.push(3);
        Assert.assertTrue(myStack.pop() == 3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        Assert.assertTrue(myStack.pop() == 6);
        Assert.assertTrue(myStack.pop() == 5);
    }
    
    @Test
    public void testPeek() {
        myStack.push(3);
        Assert.assertTrue(myStack.peek() == 3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        Assert.assertTrue(myStack.peek() == 6);
        Assert.assertTrue(myStack.peek() == 6);
    }
    
    @Test
    public void testIsEmpty() {
        myStack.push(10);
        Assert.assertFalse(myStack.isEmpty());
        myStack.pop();
        Assert.assertTrue(myStack.isEmpty());
    }
    
    @Test
    public void testSize() {
        myStack.push(10);
        myStack.push(11);
        Assert.assertTrue(myStack.size == 2);
    }

}
