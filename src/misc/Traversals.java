package misc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversals {
    
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
        }
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                Node t = stack.pop();
                System.out.println(t.data);
                p = t.right;
            }
        }
    }
    
    public static void levelOrder(Node n) {
        if(n == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            while(levelSize != 0) {
                Node r = q.remove();
                System.out.print(r.data + " ");
                if(r.left != null) {
                    q.add(r.left);
                }
                if(r.right != null) {
                    q.add(r.right);
                }
                levelSize--;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        
        n3.left = n1;
        n1.left = n0;
        n1.right = n2;
        n3.right = n5;
        n5.left = n4;
        n5.right = n6;
        
//        inorder(n3);
        levelOrder(n3);

    }
}
