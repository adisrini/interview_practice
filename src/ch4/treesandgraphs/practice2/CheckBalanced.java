package ch4.treesandgraphs.practice2;

import ch4.treesandgraphs.implementations.BNode;

public class CheckBalanced {
    
    public static boolean check(BNode<Integer> root) {
        if(root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return check(root.left) && check(root.right);
    }
    
    private static int height(BNode<Integer> node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
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

        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n6;
        n4.left = n7;
        n2.left = n5;
        n5.left = n8;
        n5.right = n9;
        n2.right = n10;
        
        System.out.println(check(n0));
    }

}
