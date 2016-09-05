package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.BinaryTreeNode;

public class PathsWithSum {
    
    private static int count = 0;
    
    /**
     * Call {@link #countHelper(BinaryTreeNode, int)} for every node in the tree
     * 
     * @param root
     * @param sum
     */
    public static void count(BinaryTreeNode<Integer> root, int sum) {
        if(root != null) {
            countHelper(root, 0, sum);
            count(root.left, sum);
            count(root.right, sum);
        }
    }
    
    /**
     * Counts number of paths that sum to the given sum with the root as the root of the tree
     * 
     * @param root
     * @param sum
     */
    public static void countHelper(BinaryTreeNode<Integer> root, int running, int target) {
        if(root != null) {
            running += root.data;
            if(running == target) {
                count++;
                return;
            }
            countHelper(root.left, running, target);
            countHelper(root.right, running, target);
        }
    }
    
    // TEST:
    // Tree                     10
    // Sum: 10
    // 
    // countHelper(node(10), 0, 10)
    //       --> running = 0 + 10 = 10
    //       --> running == target is true, so count++ (=1), and returns
    // count(node(10).left) --> returns
    // count(node(10).right) --> returns
    //
    // this gives us the right answer
    //
    // 
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);
        
        n4.left = n5;
        n5.left = n3;
        n5.right = n2;
        n3.right = n7;
        n4.right = n6;
        
        count(n4, 3);
        
        System.out.println("The count is: " + count);
        
    }

}
