package ch4.treesandgraphs.practice2;

import java.util.HashMap;
import java.util.Map;

import ch2.linkedlists.implementations.LinkedList;
import ch4.treesandgraphs.implementations.BinaryTreeNode;

public class ListOfDepths {
    
    private static Map<Integer, LinkedList> lists;

    public static Map<Integer, LinkedList> depths(BinaryTreeNode<Integer> root) {
        lists = new HashMap<>();
        util(root, 0);
        return lists;
    }
    
    private static void util(BinaryTreeNode<Integer> node, int level) {
        if(node != null) {
            util(node.left, level + 1);
            visit(node, level);
            util(node.right, level + 1);
        }
    }
    
    private static void visit(BinaryTreeNode<Integer> node, int level) {
        if(!lists.containsKey(level)) {
            lists.put(level, new LinkedList());
        }
        LinkedList ll = lists.get(level);
        ll.add(node.data);
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
