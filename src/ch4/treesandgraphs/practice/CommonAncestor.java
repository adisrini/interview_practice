package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.BinaryTreeNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing
 * additional nodes in a data structure. NOTE: This is not necessarily a binary search tree. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class CommonAncestor {

    // It is important to consider what is allowed here. If we assume that nodes have access to their parents, this gives
    // us our first answer.
    //
    // *******************
    // **** ANSWER 1: ****
    // *******************
    //
    // We traverse upwards from a node (following its parents) until there is no parent (we hit the root). While doing this for
    // both nodes, we count the length of the path from it to the root. We find the absolute difference and traverse the node
    // further away upwards by this distance as a headstart. Then, we traverse them simultaneously upwards until they reach
    // a node that is the same (by reference). This is the common ancestor.
    //
    
    static class Difference {
        BinaryTreeNode<Integer> furtherNode;
        int difference;
    }
    
//    public static BinaryTreeNode<Integer> ancestor1(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2)  {
//        if(n1 == n2) return n1;     // they are the same node, so their first common ancestor is themselves
//        Difference difference = findDifferenceInPaths(n1, n2);
//        for(int i = 0; i < difference.difference; i++) {
//            difference.furtherNode = difference.furtherNode.parent;
//        }
//        while(n1 != n2) {
//            n1 = n1.parent;
//            n2 = n2.parent;
//        }
//        return n1;
//    }
//    
//    public static Difference findDifferenceInPaths(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
//        int length1, length2;
//        while(n1.parent != null || n2.parent != null) {
//            if(n1.parent != null) {
//                n1 = n1.parent;
//                length1++;
//            }
//            if(n2.parent != null) {
//                n2 = n2.parent;
//                length2++;
//            }
//        }
//        Difference difference = new Difference();
//        if(length1 > length2) {
//            difference.furtherNode = n1;
//        } else if(length1 < length2) {
//            difference.furtherNode = n2;
//        } else {
//            difference.furtherNode = n1     // there is no "further node" in this case, we can just arbitrarily call it n1 since it'll only progress 0 in any case
//        }
//        difference.difference = Math.abs(length1 - length2);
//        return difference;
//    }
    
    // But if this is not allowed, we must do something different.
    //
    // We must find the deepest node n such that p and q are both descendants of n.
    // We know for sure that the root satisfies this, but it may not be the deepest possible node.
    //
    // If we checked this for every node n, we could find the last node for which this is true, but that
    // would be a poor runtime, since we are traversing the subtree of every node.
    //
    // Let's try this. We start at the root. We check each subtree and determine which one p and q are in.
    // If p and q are in different subtrees, we return that the root is the first common ancestor.
    //
    // If they are in the same subtree, we go to that side and repeat the process with that node
    //
    // We must also consider the case where p is a descendent of q (or vice versa). If we get to a node and
    // find that the subtree that q belongs in is null, that means we are at q, so if either result is null
    // we can return the node we are currently at
    
    public static BinaryTreeNode<Integer> ancestor2(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        
        while(root != null) {
            if(root == p || root == q) {
                return (root == p) ? p : q;         // if the root is one of the nodes we are looking for, then the other must be a descendant, so return it.
            }
            Side pSide = findSide(root, p);
            Side qSide = findSide(root, q);
            if(pSide != qSide) {
                return root;
            } else {
                if(pSide == Side.LEFT) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }   
        }
        
        return null;
        
    }
    
    public static Side findSide(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> child) {
        if(inSubtree(root.left, child)) return Side.LEFT;
        else if(inSubtree(root.right, child)) return Side.RIGHT;
        else return Side.NEITHER;
    }
    
    //            3
    //           / \
    //          0   5
    //         / \
    //        1   2
    //
    // inSubtree(3, 2)
    //      --> return inSubtree(0, 2) || inSubtree(5, 2)
    //                  --> return inSubtree(1, 2) || inSubtree(2, 2)
    //                             --> return inSubtree(null, 2) || inSubtree(null, 2) = false
    //                             (false) || inSubtree(2, 2) = true
    //                  --> return true
    //      --> return true
    // inSubtree(1, 2)
    //      --> return inSubtree(null, 2) || inSubtree(null, 2) = false
    //              
    
    public static boolean inSubtree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> child) {
        if(root != null) {
            if(root == child) return true;
            return inSubtree(root.left, child) || inSubtree(root.right, child);
        }
        return false;
    }
    
    enum Side {
        LEFT, RIGHT, NEITHER;
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> n10 = new BinaryTreeNode<Integer>(10);
        BinaryTreeNode<Integer> n15 = new BinaryTreeNode<Integer>(15);
        BinaryTreeNode<Integer> n17 = new BinaryTreeNode<Integer>(17);
        
        n6.left = n4;
        n4.left = n15;
        n15.left = n1;
        n15.right = n2;
        n4.right = n17;
        n6.right = n10;
        n10.left = n7;
        n10.right = n3;
        n3.left = n5;
        
        System.out.println(ancestor2(n6, n1, n17));
        
    }

}
