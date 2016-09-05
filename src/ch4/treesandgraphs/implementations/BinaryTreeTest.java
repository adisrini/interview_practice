package ch4.treesandgraphs.implementations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
    
    private BinaryTree<Integer> bt;
    
    @Before
    public void setUp() {
        bt = new BinaryTree<>();
        bt.root = new BinaryTreeNode<Integer>(4);
        bt.root.left = new BinaryTreeNode<Integer>(2);
        bt.root.right = new BinaryTreeNode<Integer>(6);
        bt.root.left.left = new BinaryTreeNode<Integer>(1);
        bt.root.left.right = new BinaryTreeNode<Integer>(3);
        bt.root.right.left = new BinaryTreeNode<Integer>(5);
        bt.root.right.right = new BinaryTreeNode<Integer>(7);
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
