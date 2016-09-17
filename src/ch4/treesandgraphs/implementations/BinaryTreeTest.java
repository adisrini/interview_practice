package ch4.treesandgraphs.implementations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
    
    private BinaryTree<Integer> bt;
    
    @Before
    public void setUp() {
        bt = new BinaryTree<>();
        bt.root = new BNode<Integer>(4);
        bt.root.left = new BNode<Integer>(2);
        bt.root.right = new BNode<Integer>(6);
        bt.root.left.left = new BNode<Integer>(1);
        bt.root.left.right = new BNode<Integer>(3);
        bt.root.right.left = new BNode<Integer>(5);
        bt.root.right.right = new BNode<Integer>(7);
    }
    
    @After
    public void tearDown() {
        bt = null;
    }
    
    @Test
    public void testInorder() {
        System.out.println("\nINORDER\n=======");
        bt.inorder(bt.root);
    }
    
    @Test
    public void testPreorder() {
        System.out.println("\nPREORDER\n=======");
        bt.preorder(bt.root);
    }
    
    @Test
    public void testPostorder() {
        System.out.println("\nPOSTORDER\n=======");
        bt.postorder(bt.root);
    }

}
