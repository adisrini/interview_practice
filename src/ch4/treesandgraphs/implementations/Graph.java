package ch4.treesandgraphs.implementations;

import ch3.stacksqueues.implementations.Queue;

public class Graph {
    
    public Vertex root;
    
    public void dfs(Vertex root) {
        if(root == null) return;
        System.out.println(root.data);
        root.visited = true;
        for(Vertex v : root.neighbors) {
            if(!v.visited) {
                dfs(v);
            }
        }
    }
    
    public void bfs(Vertex root) {
        Queue<Vertex> queue = new Queue<Vertex>();
        root.visited = true;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Vertex v = queue.remove();
            System.out.println(root.data);
            for(Vertex vv : v.neighbors) {
                if(!vv.visited) {
                    vv.visited = true;
                    queue.add(vv);
                }
            }
        }
        
    }

}
