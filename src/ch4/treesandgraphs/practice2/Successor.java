package ch4.treesandgraphs.practice2;

import ch4.treesandgraphs.implementations.BNode;

public class Successor {
    
    private static boolean seen = false;
    private static BNode<Integer> successor;

    public static BNode<Integer> successor(BNode<Integer> root, BNode<Integer> node) {
        traverse(root, node);
        return successor;
    }
    
    private static void traverse(BNode<Integer> root, BNode<Integer> orig) {
        if(root != null) {
            traverse(root.left, orig);
            if(seen) {
                successor = root;
                seen = false;
            }
            if(root == orig) {
                seen = true;
            }
            traverse(root.right, orig);
        }
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
        
        n4.left = n2;
        n4.right = n8;
        n8.left = n6;
        n6.right = n7;
        
        System.out.println(successor(n4, n8));
    }
}
