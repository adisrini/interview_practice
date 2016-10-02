package ch4.treesandgraphs.practice3;

import java.util.LinkedList;
import java.util.Queue;

import ch4.treesandgraphs.implementations.Graph;
import ch4.treesandgraphs.implementations.Vertex;

public class RouteBetweenNodes {
    
    static boolean isRoute(Vertex v1, Vertex v2) {
        if(v1 == v2) {
            return true;
        }
        if(v1 == null || v2 == null) {
            return false;
        }
        Queue<Vertex> q = new LinkedList<>();
        q.add(v1);
        v1.visited = true;
        
        while(!q.isEmpty()) {
            Vertex removed = q.remove();
            if(removed == v2) {
                return true;
            }
            for(Vertex neighbor : removed.neighbors) {
                if(!neighbor.visited) {
                    neighbor.visited = true;
                    q.add(neighbor);
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        graph.root = v0;
        v0.neighbors = new Vertex[]{v1, v4, v5};
        v1.neighbors = new Vertex[]{v3, v4};
        v2.neighbors = new Vertex[]{v1};
        v3.neighbors = new Vertex[]{v2, v4};
        v4.neighbors = new Vertex[0];
        v5.neighbors = new Vertex[0];
        System.out.println(RouteBetweenNodes.isRoute(v0, v1));
    }

}
