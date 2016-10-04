package leetcode;

import ch4.treesandgraphs.implementations.BNode;
import ch4.treesandgraphs.practice.Traversal;

public class InvertTree {

    public static void invert(BNode<Integer> root) {
        if(root != null) {
            BNode<Integer> left = root.left;
            root.left = root.right;
            root.right = left;
            invert(root.left);
            invert(root.right);
        }
    }
    
    public static void main(String[] args) {
        BNode<Integer> n0 = new BNode<>(0);
        BNode<Integer> n1 = new BNode<>(1);
        BNode<Integer> n2 = new BNode<>(2);
        BNode<Integer> n3 = new BNode<>(3);
        BNode<Integer> n4 = new BNode<>(4);
        
        n0.left = n1;
        n1.left = n2;
        n0.right = n4;
        n4.left = n3;
        
        Traversal.inorder(n0);
        
        invert(n0);
        
        Traversal.inorder(n0);
    }
    
}
