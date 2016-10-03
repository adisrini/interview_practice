package ch4.treesandgraphs.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
    
    static class Vertex {
        int data;
        boolean visited;
        Collection<Vertex> neighbors = new ArrayList<>();
        
        Vertex(int data) {
            this.data = data;
        }
    }
    
//    public static void dfs_r(Vertex v) {
//        if(v == null) {
//            return;
//        }
//        v.visited = true;
//        System.out.println(v.data);
//        for(Vertex neighbor : v.neighbors) {
//            if(!neighbor.visited) {
//                dfs_r(neighbor);
//            }
//        }
//    }
    
    public static void dfs_r(Vertex v) {
        if(v != null) {
            System.out.println(v.data);
            v.visited = true;
            for(Vertex n : v.neighbors) {
                if(!n.visited) {
                    dfs_r(n);
                }
            }
        }
    }
    
    public static void dfs_i(Vertex v) {
        if(v == null) {
            return;
        }
        Stack<Vertex> stack = new Stack<Vertex>();
        stack.push(v);
        v.visited = true;
        
        while(!stack.isEmpty()) {
            Vertex r = stack.pop();
            System.out.println(r.data);
            for(Vertex n : r.neighbors) {
                if(!n.visited) {
                    n.visited = true;
                    stack.push(n);
                }
            }
        }
    }
    
    public static void bfs(Vertex v) {
        if(v == null) {
            return;
        }
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(v);
        v.visited = true;
        
        while(!queue.isEmpty()) {
            Vertex r = queue.remove();
            System.out.println(r.data);
            for(Vertex n : r.neighbors) {
                if(!n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        v0.neighbors.addAll(Arrays.asList(v1, v2, v3));
        v2.neighbors.addAll(Arrays.asList(v4, v5));
        
//        dfs_r(v0);
//        dfs_i(v0);
        bfs(v0);
        
    }

}
