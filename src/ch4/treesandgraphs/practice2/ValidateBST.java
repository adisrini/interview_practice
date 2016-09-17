package ch4.treesandgraphs.practice2;

import ch4.treesandgraphs.implementations.BinaryTreeNode;

public class ValidateBST {
    
    private static int max = Integer.MIN_VALUE;
    
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return true;
        }
        boolean left = isBST(root.left);
        if(root.data < max) {
            return false;
        } else {
            max = root.data;
        }
        boolean right = isBST(root.right);
        return left && right;
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> n0 = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> n8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> n9 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> n10 = new BinaryTreeNode<>(10);

        n3.left = n1;
        n1.left = n0;
        n1.right = n2;
        n3.right = n6;
        n6.left = n4;
        n4.right = n5;
        n6.right = n10;
        n10.left = n8;
        n8.left = n9;
        n9.left = n7;
        
        System.out.println(isBST(n3));
    }

}
