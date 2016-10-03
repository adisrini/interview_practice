package ch4.treesandgraphs.practice3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ch4.treesandgraphs.implementations.BNode;

public class ListOfDepths {
    
    static List<LinkedList<BNode<Integer>>> depths(BNode<Integer> root) {
        if(root == null) return null;
        
        List<LinkedList<BNode<Integer>>> lists = new ArrayList<>();
        Queue<BNode<Integer>> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int levelNodes = q.size();
            LinkedList<BNode<Integer>> list = new LinkedList<>();
            while(levelNodes > 0) {
                BNode<Integer> r = q.remove();
                if(r.left != null) {
                    q.add(r.left);
                }
                if(r.right != null) {
                    q.add(r.right);
                }
                list.add(r);
                levelNodes--;
            }
            lists.add(list);
        }
        
        return lists;
    }
    
    public static void main(String[] args) {
        BNode<Integer> n0 = new BNode<Integer>(0);
        BNode<Integer> n1 = new BNode<Integer>(1);
        BNode<Integer> n2 = new BNode<Integer>(2);
        BNode<Integer> n3 = new BNode<Integer>(3);
        BNode<Integer> n4 = new BNode<Integer>(4);
        BNode<Integer> n5 = new BNode<Integer>(5);
        BNode<Integer> n6 = new BNode<Integer>(6);
        BNode<Integer> n7 = new BNode<Integer>(7);
        
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n6.left = n7;
        
        System.out.println(depths(n0));
        
    }

}
