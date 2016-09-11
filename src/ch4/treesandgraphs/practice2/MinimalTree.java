package ch4.treesandgraphs.practice2;

import ch4.treesandgraphs.implementations.BinaryTreeNode;
import ch4.treesandgraphs.practice.Traversal;

public class MinimalTree {
    
    public static BinaryTreeNode<Integer> minimal(int[] array) {
        return minimal(0, array.length - 1, array);
    }
    
    private static BinaryTreeNode<Integer> minimal(int start, int end, int[] array) {
        int mid = (start + end) / 2;
        if(start >= end) {
            return new BinaryTreeNode<>(array[mid]);
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(array[mid]);
        root.left = minimal(start, mid - 1, array);
        root.right = minimal(mid + 1, end, array);
        
        return root;
    }
    
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6};
        BinaryTreeNode<Integer> root = minimal(array);
        Traversal.inorder(root);
    }

}
