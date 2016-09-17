package ch4.treesandgraphs.practice2;

import java.util.HashMap;
import java.util.Map;

import ch2.linkedlists.implementations.LinkedList;
import ch4.treesandgraphs.implementations.BNode;

public class ListOfDepths {
    
    private static Map<Integer, LinkedList> lists;

    public static Map<Integer, LinkedList> depths(BNode<Integer> root) {
        lists = new HashMap<>();
        util(root, 0);
        return lists;
    }
    
    private static void util(BNode<Integer> node, int level) {
        if(node != null) {
            util(node.left, level + 1);
            visit(node, level);
            util(node.right, level + 1);
        }
    }
    
    private static void visit(BNode<Integer> node, int level) {
        if(!lists.containsKey(level)) {
            lists.put(level, new LinkedList());
        }
        LinkedList ll = lists.get(level);
        ll.add(node.data);
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

        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n6;
        n4.left = n7;
        n2.left = n5;
        n5.left = n8;
        n5.right = n9;
        
        System.out.println(depths(n0));
        
    }
    
}
