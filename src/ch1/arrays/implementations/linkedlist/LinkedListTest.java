package ch1.arrays.implementations.linkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    
    private ILinkedList<String> linkedList;
    
    @Before
    public void setUp() {
        INode<String> head = new Node<String>(null, "A");
        linkedList = new LinkedList<String>(head);
    }
    
    @After
    public void tearDown() {
        linkedList = null;
    }
    
    @Test
    public void testAdd() {
        linkedList.add("B");
        Assert.assertEquals("A -> B -> ", linkedList.print());
    }
    
    @Test
    public void testDeleteByIndex() {
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        Assert.assertTrue(linkedList.delete(0));
        Assert.assertEquals("B -> C -> D -> ", linkedList.print());
        Assert.assertTrue(linkedList.delete(1));
        Assert.assertEquals("B -> D -> ", linkedList.print());
    }
    
    @Test
    public void testDeleteByElement() {
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        Assert.assertTrue(linkedList.delete("A"));
        Assert.assertEquals("B -> C -> D -> ", linkedList.print());
        Assert.assertTrue(linkedList.delete("C"));
        Assert.assertEquals("B -> D -> ", linkedList.print());
        Assert.assertTrue(linkedList.delete("D"));
        Assert.assertEquals("B -> ", linkedList.print());
    }
    
    @Test
    public void testInvalidDeletion() {
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        Assert.assertFalse(linkedList.delete("E"));
        Assert.assertFalse(linkedList.delete(4));
    }
    
    @Test
    public void testSize() {
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        Assert.assertEquals(4, linkedList.size());
    }
    
    @Test
    public void testGetByIndex() {
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        Assert.assertEquals("A", linkedList.get(0));
        Assert.assertEquals("C", linkedList.get(2));
    }
    
    @Test
    public void testGetByElement() {
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        Assert.assertEquals("A", linkedList.get("A"));
        Assert.assertEquals("C", linkedList.get("C"));
    }
    
    @Test
    public void testGetHead() {
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        Assert.assertEquals("A", linkedList.getHead().data());
        linkedList.delete(0);
        Assert.assertEquals("B", linkedList.getHead().data());
    }

}
