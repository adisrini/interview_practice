package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.BNode;

/**
 * 
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree
 * is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class CheckBalanced {

    //
    // We need to check the subtrees of all nodes and make sure their heights do not differ by more than one.
    //
    // This is probably best done in a recursive manner, visiting each node and finding the heights of its subtrees.
    // We can do a normal traversal (inorder/postorder/preorder) and when we visit each node, we check the heights of
    // the subtrees. If they differ by more than one, we return false in the traversal, otherwise we return true at the
    // very end
    //
    
    public static boolean isBalanced(BNode<Integer> root) {
        if(root == null) return true;
        if(!balanced(root)) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public static boolean balanced(BNode<Integer> root) {
        return (Math.abs(height(root.left) - height(root.right)) <= 1);
    }
    
    // if it is an empty tree, this will return 0, as we want
    // if it is just one root, it will return 1
    // if it is this tree:          0
    //                             / \          
    //                            3   4
    //                                 \
    //                                  6
    //
    // then we start with the root, return 1 + height(3) + height(4)
    //                                  =  1 + 1 + 0 + 0 + 1 + 0 + 1
    // so it's actually counting 3 and 4 twice when it should only count it once
    //
    // so we return the max of each subtree height each call
    
    public static int height(BNode<Integer> root) {
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    
    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(0);
        BNode<Integer> n1 = new BNode<>(1);
        BNode<Integer> n2 = new BNode<>(2);
        BNode<Integer> n3 = new BNode<>(3);
        BNode<Integer> n4 = new BNode<>(4);
        root.left = n1;
        root.right = n2;
        n2.right = n3;
        n3.right = n4;
        System.out.println(CheckBalanced.isBalanced(root));
    }
    
}
