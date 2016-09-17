package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.BNode;

/**
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm to determine if T2 is a
 * subtree of T1.
 * 
 * @author Aditya Srinivasan
 *
 */
public class CheckSubtree {

    // If we are just checking by reference, we can traverse T1 until we find the same reference node as the root of T2. If
    // this never happens, we return false since it isn't contained.
    //
    // However, let's assume that we are not dealing with references and instead dealing with values.
    //
    // If T2 is a subtree of T1, then the in-order, post-order, and pre-order traversals of T2 will be substrings of the corresponding
    // traversals for T1. However, ALL of them need to be substrings, since it's possible for just the in-order to be a substring
    // even if T2 isn't a subtree of T1.
    //
    // This is time complexity of O(N), which is expected, but is also space complexity of O(N), which we may be able to do better?
    //
    // If we assume that there are no duplicates, we can do better. We find the node n in T1 that has the same value as the root of
    // T2 (null if there is no match, and just return false).
    //
    // We then traverse (in any order) starting at node n and the root of T2. If at any point the values are different, we return
    // false, else we return true.
    //
    // This does not require any additional buffers.
    
    private static BNode<Integer> matchingNodeInT1 = null;
    
    public static boolean isSubtree(BNode<Integer> root1, BNode<Integer> root2) {
        if(root1 == null || root2 == null) {
            if(root1 != null) return true;              // if T2 is null, but T1 isn't, it is technically a subtree so return true
            if(root2 != null) return false;             // if T1 is null, but T2 isn't, T2 can't be a subtree so return false
            return true;                                // if both T1 and T2 are null, T2 is technically a subtree so return true
        }
        match(root1, root2);
        if(matchingNodeInT1 == null) return false;      // no match
        return parallelTraverse(matchingNodeInT1, root2);
    }
    
    // t1:                      0                       t2:             0
    //                         / \                                       \
    //                        1   2                                       2
    //                           /                                       /
    //                          3                                       3
    //
    // parallelTraverse(0, 0) --> parallelTraverse(1, null) && parallelTraverse(2, 2)
    //                                                true     parallelTraverse(3, 3) && parallelTraverse(null, null)
    //                                                                      true            true
    // All true, but that's wrong. We need to check that BOTH are null
    //
    // pT(0, 0) --> pT(1, null) && parallelTraverse(2, 2)
    //              false
    // Returns false
    
    public static boolean parallelTraverse(BNode<Integer> t1, BNode<Integer> t2) {
        if(t1 == null && t2 == null) {              // both are null
            return true;
        } else if(t1 == null || t2 == null) {       // only one is null
            return false;
        } else {
            if(t1.data != t2.data) return false;
            return parallelTraverse(t1.left, t2.left) && parallelTraverse(t1.right, t2.right);
        }
    }
    
    public static void match(BNode<Integer> root1, BNode<Integer> root2) {
        if(root1 != null) {
            if(root1.data == root2.data) matchingNodeInT1 = root1;
            match(root1.left, root2);
            match(root1.right, root2);
        }
    }
    
    public static void main(String[] args) {
        
        BNode<Integer> t11 = new BNode<Integer>(1);
        BNode<Integer> t12 = new BNode<Integer>(2);
        BNode<Integer> t13 = new BNode<Integer>(3);
        BNode<Integer> t14 = new BNode<Integer>(4);
        BNode<Integer> t15 = new BNode<Integer>(5);
        BNode<Integer> t16 = new BNode<Integer>(6);
        BNode<Integer> t17 = new BNode<Integer>(7);
        BNode<Integer> t18 = new BNode<Integer>(8);
        BNode<Integer> t19 = new BNode<Integer>(9);
        BNode<Integer> t110 = new BNode<Integer>(10);
        BNode<Integer> t111 = new BNode<Integer>(11);
        BNode<Integer> t26 = new BNode<Integer>(6);
        BNode<Integer> t27 = new BNode<Integer>(7);
        BNode<Integer> t28 = new BNode<Integer>(8);
        
        t11.left = t12;
        t12.left = t14;
        t12.right = t15;
        t11.right = t13;
        t13.left = t16;
        t16.left = t17;
        t16.right = t18;
        t13.right = t19;
        t19.left = t110;
        t19.right = t111;
        
        t26.left = t27;
        t26.right = t28;
        
        System.out.println(isSubtree(t11, t26));
        
    }

}
