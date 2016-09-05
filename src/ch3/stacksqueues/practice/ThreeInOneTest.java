package ch3.stacksqueues.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class ThreeInOneTest {
    
    ThreeInOne tio;
    
    @Before
    public void setUp() {
        tio = new ThreeInOne(10, 4);
    }
    
    @After
    public void tearDown() {
        tio = null;
    }
    
    @Test
    public void testPushAndPop() {
        tio.push(0, 0);
        tio.push(1, 1);
        tio.push(2, 2);
        tio.push(3, 0);
        tio.push(4, 1);
        tio.push(5, 2);
        tio.push(6, 0);
        tio.push(7, 1);
        tio.push(8, 2);
        Assert.assertEquals(8, tio.pop(2));
        Assert.assertEquals(6, tio.pop(0));
        Assert.assertEquals(7, tio.pop(1));
        Assert.assertEquals(4, tio.pop(1));
        Assert.assertEquals(3, tio.pop(0));
        Assert.assertEquals(5, tio.pop(2));
    }
    
    @Test
    public void testPeek() {
        tio.push(0, 0);
        tio.push(1, 1);
        tio.push(2, 2);
        tio.push(3, 0);
        tio.push(4, 1);
        tio.push(5, 2);
        tio.push(6, 0);
        tio.push(7, 1);
        tio.push(8, 2);
        Assert.assertEquals(8, tio.peek(2));
        Assert.assertEquals(6, tio.peek(0));
        Assert.assertEquals(7, tio.peek(1));
        Assert.assertEquals(7, tio.peek(1));
        Assert.assertEquals(6, tio.peek(0));
        Assert.assertEquals(8, tio.peek(2));
    }
    
    @Test
    public void testIsEmpty() {
        tio.push(0, 0);
        tio.push(1, 1);
        Assert.assertFalse(tio.isEmpty(0));
        Assert.assertFalse(tio.isEmpty(1));
        Assert.assertTrue(tio.isEmpty(2));
        tio.pop(1);
        Assert.assertTrue(tio.isEmpty(1));
        Assert.assertTrue(tio.isEmpty(3));
    }

}
