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
}
