package ch4.treesandgraphs.implementations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch3.stacksqueues.implementations.Queue;
import ch3.stacksqueues.implementations.Stack;

public class GraphTest {
    
    private Graph graph;
    
    @Before
    public void setUp() {
        graph = new Graph();
        graph.root = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        graph.root.neighbors = new Vertex[]{v1, v4, v5};
        v1.neighbors = new Vertex[]{v3, v4};
        v2.neighbors = new Vertex[]{v1};
        v3.neighbors = new Vertex[]{v2, v4};
        v4.neighbors = new Vertex[0];
        v5.neighbors = new Vertex[0];
    }
    
    @After
    public void tearDown() {
        graph = null;
    }
    
    @Test
    public void testDFS() {
        System.out.println("\nDFS\n====");
        dfs(graph.root);
    }
    
    @Test
    public void testDFS2() {
        System.out.println("\nDFS2\n====");
        dfs2(graph.root);
    }
    
    @Test
    public void testBFS() {
        System.out.println("\nBFS\n====");
        bfs(graph.root);
    }
    
    private void dfs(Vertex root) {
        if(root == null) return;
        System.out.println(root.data);
        root.visited = true;
        for(Vertex neighbor : root.neighbors) {
            if(!neighbor.visited) {
                dfs(neighbor);
            }
        }
    }
    
    private void bfs(Vertex root) {
        Queue<Vertex> queue = new Queue<Vertex>();
        root.visited = true;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Vertex r = queue.remove();
            System.out.println(r.data);
            for(Vertex neighbor : r.neighbors) {
                if(!neighbor.visited) {
                    neighbor.visited = true;
                    queue.add(neighbor);
                }
            }
        }
        
    }
    
    private void dfs2(Vertex root) {
        Stack<Vertex> stack = new Stack<Vertex>();
        root.visited = true;
        stack.push(root);
        
        while(!stack.isEmpty()) {
            Vertex r = stack.pop();
            System.out.println(r.data);
            for(Vertex neighbor : r.neighbors) {
                if(!neighbor.visited) {
                    neighbor.visited = true;
                    stack.push(neighbor);
                }
            }
        }
        
    }

}
