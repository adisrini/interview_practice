package ch4.treesandgraphs.practice2;

import ch4.treesandgraphs.implementations.BinaryTreeNode;

public class CheckBalanced {
    
    public static boolean check(BinaryTreeNode<Integer> root) {
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
    
    private static int height(BinaryTreeNode<Integer> node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
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
