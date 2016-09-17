package ch4.treesandgraphs.practice2;

import ch4.treesandgraphs.implementations.BNode;

public class BTisBST {
    
    public static boolean isBST(BNode<Integer> root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean isBSTUtil(BNode<Integer> root, int min, int max) {
        if(root == null) {      // an empty tree is a BST
            return true;
        }
        if(root.data < min || root.data > max) {
            return false;
        }
        return isBSTUtil(root.left, min, root.data - 1) &&
               isBSTUtil(root.right, root.data + 1, max);
    }
    
    public static void main(String[] args) {
        BNode<Integer> n1 = new BNode<>(1);
        BNode<Integer> n2 = new BNode<>(2);
        BNode<Integer> n3 = new BNode<>(3);
        BNode<Integer> n4 = new BNode<>(4);
        BNode<Integer> n5 = new BNode<>(5);
        BNode<Integer> n6 = new BNode<>(6);
        
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n5;
        n5.right = n6;
        
        System.out.println(isBST(n4));
    }

}
