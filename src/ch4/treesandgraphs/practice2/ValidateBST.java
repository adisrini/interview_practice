package ch4.treesandgraphs.practice2;

import ch4.treesandgraphs.implementations.BNode;

public class ValidateBST {
    
    private static int max = Integer.MIN_VALUE;
    
    public static boolean isBST(BNode<Integer> root) {
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
        BNode<Integer> n0 = new BNode<>(0);
        BNode<Integer> n1 = new BNode<>(1);
        BNode<Integer> n2 = new BNode<>(2);
        BNode<Integer> n3 = new BNode<>(3);
        BNode<Integer> n4 = new BNode<>(4);
        BNode<Integer> n5 = new BNode<>(5);
        BNode<Integer> n6 = new BNode<>(6);
        BNode<Integer> n7 = new BNode<>(7);
        BNode<Integer> n8 = new BNode<>(8);
        BNode<Integer> n9 = new BNode<>(9);
        BNode<Integer> n10 = new BNode<>(10);

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
