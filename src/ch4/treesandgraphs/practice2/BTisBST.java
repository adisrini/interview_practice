package ch4.treesandgraphs.practice2;

import ch4.treesandgraphs.implementations.BinaryTreeNode;

public class BTisBST {
    
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean isBSTUtil(BinaryTreeNode<Integer> root, int min, int max) {
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
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n5;
        n5.right = n6;
        
        System.out.println(isBST(n4));
    }

}
