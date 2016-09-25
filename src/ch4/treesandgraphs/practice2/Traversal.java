package ch4.treesandgraphs.practice2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ch4.treesandgraphs.implementations.BNode;

public class Traversal {
    
    public void inorder_r(BNode<Integer> node) {
        if(node != null) {
            inorder_r(node.left);
            System.out.println(node);
            inorder_r(node.right);
        }
    }
    
    public void preorder_r(BNode<Integer> node) {
        if(node != null) {
            System.out.println(node);
            inorder_r(node.left);
            inorder_r(node.right);
        }
    }
    
    public void postorder_r(BNode<Integer> node) {
        if(node != null) {
            inorder_r(node.left);
            inorder_r(node.right);
            System.out.println(node);
        }
    }
    
    public void inorder_i(BNode<Integer> node) {
        if(node == null) {
            return;
        }
        
        Stack<BNode<Integer>> stack = new Stack<>();
        
        BNode<Integer> curr = node;
        
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BNode<Integer> popped = stack.pop();
                System.out.println(popped.data);
                curr = popped.right;
            }
        }
    }
    
    public void levelOrder(BNode<Integer> node) {
        if(node == null) {
            return;
        }
        
        Queue<BNode<Integer>> queue = new LinkedList<BNode<Integer>>();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            while(levelSize > 0) {
                BNode<Integer> r = queue.remove();
                System.out.print(r.data + " ");
                if(r.left != null) {
                    queue.add(r.left);
                }
                if(r.right != null) {
                    queue.add(r.right);
                }
                levelSize--;
            }
            System.out.println();
        }

    }
    
    public void topView(BNode<Integer> node) {
        BNode<Integer> p = node;
        printLeftReverse(p);
        printRight(p.right);
    }
    
    private void printLeftReverse(BNode<Integer> node) {
        if(node != null) {
            printLeftReverse(node.left);
            System.out.println(node.data);
        }
    }
    
    private void printRight(BNode<Integer> node) {
        if(node != null) {
            System.out.println(node.data);
            printRight(node.right);
        }
    }
    
    
    public static void main(String[] args) {
        Traversal t = new Traversal();
        
        BNode<Integer> n0 = new BNode<>(0);
        BNode<Integer> n1 = new BNode<>(1);
        BNode<Integer> n2 = new BNode<>(2);
        BNode<Integer> n3 = new BNode<>(3);
        BNode<Integer> n4 = new BNode<>(4);
        BNode<Integer> n5 = new BNode<>(5);
        BNode<Integer> n6 = new BNode<>(6);
        
        n3.left = n1;
        n1.left = n0;
        n1.right = n2;
        n3.right = n5;
        n5.left = n4;
        n5.right = n6;
        
        t.inorder_r(n3);
        System.out.println("----------");
        t.preorder_r(n3);
        System.out.println("----------");
        t.postorder_r(n3);
        System.out.println("----------");
        t.inorder_i(n3);
        System.out.println("----------");
        t.levelOrder(n3);
        System.out.println("----------");
        t.topView(n3);
    }

}
