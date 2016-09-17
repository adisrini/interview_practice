package ch4.treesandgraphs.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import ch4.treesandgraphs.implementations.BNode;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g.,
 * if you have a tree with depth D, you'll have D linked lists). 
 * 
 * @author Aditya Srinivasan
 *
 */
public class ListOfDepths {

    // We should do a tree traversal and keep track of which level we are on.
    //
    // If we are reverting back to a parent, we subtract 1 from the count
    //
    // If we are going to a left/right child, we add 1 to our count
    //
    // Whenever we visit a node, we add it to an array of linked lists at the index of whatever
    // the count is
    //
    // We can do any kind of traversal, since we will touch all nodes
    //
    // This is time complexity O(n), since we must touch all of the nodes
    //
    // It's space complexity of O(d) where d is the depth of the tree. Technically it's O(n) since we will have
    // n items divided among d linked lists.
    //
    // Instead of using an array, which we will need to know the length for before we start, we can use a map
    // from integer to LinkedList. This will allow us to more dynamically create our data structure and reduce
    // the number of passes we need to make.
    //
    
    public static Map<Integer, LinkedList<BNode<Integer>>> list(BNode<Integer> root) {
        Map<Integer, LinkedList<BNode<Integer>>> map = new HashMap<Integer, LinkedList<BNode<Integer>>>();
        listHelper(root, 1, map);
        return map;
    }
    
    public static void listHelper(BNode<Integer> root, int depth, Map<Integer, LinkedList<BNode<Integer>>> map) {
        if(root != null) {
            visit(root, depth, map);
            depth++;
            listHelper(root.left, depth, map);
            listHelper(root.right, depth, map);
            depth--;
        }
    }
    
    private static void visit(BNode<Integer> root, int depth, Map<Integer, LinkedList<BNode<Integer>>> map) {
        LinkedList<BNode<Integer>> list = (map.containsKey(depth)) ? map.get(depth) : new LinkedList<BNode<Integer>>();
        list.add(root);
        map.put(depth, list);
    }
    
    // call it with a single root with depth 1
    // 
    // we visit the root, depth = 1, map is empty
    // the map doesn't contain key 1 so we create a new linked list, add the root, and put it in the map
    //
    // --> listHelper(left) -> returns
    // --> listHelper(right -> returns
    //
    // we return the map with {1: {root}}
    //
    
    // call it with the tree
    //
    //          0
    //         / \
    //        /   \
    //       1     2
    //              \
    //               3
    //
    // we want map with {1: {0}, 2: {1, 2}, 3: {3}}
    //
    // we call at root with depth 1
    // we visit the root and put {1: {0}} in the map
    // depth = 2 now
    // --> listHelper(left) -> we visit with depth = 2, and the map
    //                      -> we put {2: {1}} in the map
    //                      -> depth = 3 now
    //                      --> list(left) returns
    //                      --> list(right) returns
    //                      -> depth = 2 now
    // --> listHelper(right -> we visit with depth = 2
    //                      -> we put {2: {1, 2}} in the map
    //                      -> depth = 3 now
    //                      -> list(left) returns
    //                      -> list(right) -> we visit with depth = 3
    //                                     -> we put {3: {3}} in the map
    //                                     -> list(left) returns
    //                                     -> list(right) returns
    //                                     -> depth = 2 now
    //                      -> depth = 1 now
    // depth = 0 now
    // the map contains what we want
    
    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(0);
        BNode<Integer> n1 = new BNode<>(1);
        BNode<Integer> n2 = new BNode<>(2);
        BNode<Integer> n3 = new BNode<>(3);
        root.left = n1;
        root.right = n2;
        n2.right = n3;
        Map<Integer, LinkedList<BNode<Integer>>> map = ListOfDepths.list(root);
        System.out.println(map);
    }
}
