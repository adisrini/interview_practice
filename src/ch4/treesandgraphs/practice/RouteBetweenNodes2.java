package ch4.treesandgraphs.practice;

import ch3.stacksqueues.implementations.Queue;
import ch4.treesandgraphs.implementations.Graph;
import ch4.treesandgraphs.implementations.Vertex;

/**
 * Route Between Nodes
 * 
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * 
 * @author Aditya Srinivasan
 *
 */
public class RouteBetweenNodes2 {
    
    static class VertexDistance {
        Vertex v;
        int distance;
        
        public VertexDistance(Vertex v, int distance) {
            this.v = v;
            this.distance = distance;
        }
    }
        
    public static boolean isConnected(Vertex v1, Vertex v2) {
        if(v1 == v2) {
            return true;
        }
        Queue<VertexDistance> queue = new Queue<VertexDistance>();
        v1.visited = true;
        queue.add(new VertexDistance(v1, 0));
        
        int i = 0;
        while(!queue.isEmpty()) {
            VertexDistance vd = queue.remove();
            Vertex r = vd.v;
            System.out.println(String.format("Vertex (%d) at distance (%d)", r.data, vd.distance));
            if(v2 == r) {
                return true;
            }
            for(Vertex neighbor : r.neighbors) {
                if(!neighbor.visited) {
                    neighbor.visited = true;
                    queue.add(new VertexDistance(neighbor, i));
                }
            }
            i++;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.root = new Vertex(0);
        Vertex v0 = graph.root;
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
        System.out.println(isConnected(v0, new Vertex(6)));
    }

}
