package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTree {
    
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
        }
        
        @Override
        public String toString() {
            return Integer.toString(data);
        }
    }

    public List<Integer> inorderTraversal(Node root) {
        List<Integer> vals = new ArrayList<>();
        if(root == null) {
            return vals;
        }
        Stack<Node> stack = new Stack<>();
        
        return vals;
    }
    
    public static void main(String[] args) {
        InorderTree i = new InorderTree();
        Node n3 = new Node(3);
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n9 = new Node(9);
        Node n7 = new Node(7);
        Node n11 = new Node(11);
        
        n3.left = n0;
        n0.right = n2;
        n2.left = n1;
        n3.right = n9;
        n9.left = n7;
        n9.right = n11;
        
        System.out.println(i.inorderTraversal(n3));
    }

}
