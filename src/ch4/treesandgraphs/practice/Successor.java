package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.BNode;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 * 
 * @author Aditya Srinivasan
 *
 */
public class Successor {

    //
    // We're given a node in a binary search tree and we need to find it's successor
    //
    // When doing an in-order traversal, we start off at the left-most, then go to its parent, then go right, then go up
    // and continue
    //
    // So, if we are at a node that is a left node with no right child, its successor will be its parent
    // if we are at a node that is a right node with no right child, it will have no successor
    // if we are at a node with a right child, the right child will be its successor
    // 
    
    public static BNode<Integer> successor(BNode<Integer> node) {
        if(node == null) return null;
        
        if(node.right != null) {
            return leftMostNode(node.right);
        } else {
            BNode<Integer> q = node;
            BNode<Integer> x = null; //q.parent;
            
            while(x != null && x.left != q) {
                q = x;
                x = null; //x.parent;
            }
            
            return x;
        }
    
    }
    
    public static BNode<Integer> leftMostNode(BNode<Integer> node) {
        if(node == null) return null;
        
        while(node.left != null) {
            node = node.left;
        }
        
        return node;
    }
    
}
