package ch4.treesandgraphs.practice;

import java.util.LinkedList;
import java.util.Queue;

import ch4.treesandgraphs.implementations.BinaryTreeNode;
import ch4.treesandgraphs.implementations.Vertex;

public class Traversal {
    
    public static void inorder(BinaryTreeNode<Integer> root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
    
    public static void preorder(BinaryTreeNode<Integer> root) {
        if(root != null) {
            System.out.println(root.data);
            inorder(root.left);
            inorder(root.right);
        }
    }
    
    public static void postorder(BinaryTreeNode<Integer> root) {
        if(root != null) {
            inorder(root.left);
            inorder(root.right);
            System.out.println(root.data);
        }
    }
    
    public static void dfs(Vertex node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data);
        node.visited = true;
        for(Vertex v : node.neighbors) {
            if(!v.visited) {
                dfs(v);
            }
        }
    }
    
    public static void bfs(Vertex node) {
        Queue<Vertex> queue = new LinkedList<>();
        node.visited = true;
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Vertex r = queue.remove();
            System.out.println(r.data);
            for(Vertex v : r.neighbors) {
                if(!v.visited) {
                    v.visited = true;
                    queue.add(v);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n5;
        n5.right = n6;
        
//        inorder(n4);
//        System.out.println();
//        preorder(n4);
//        System.out.println();
//        postorder(n4);
//        System.out.println();
        
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        v0.neighbors = new Vertex[]{ v1, v4, v5 };
        v1.neighbors = new Vertex[]{ v4, v3 };
        v2.neighbors = new Vertex[]{ v1 };
        v3.neighbors = new Vertex[]{ v4, v2 };
        v4.neighbors = new Vertex[]{};
        v5.neighbors = new Vertex[]{};
        
//        dfs(v0);
//        System.out.println();
        bfs(v0);
        
    }

}