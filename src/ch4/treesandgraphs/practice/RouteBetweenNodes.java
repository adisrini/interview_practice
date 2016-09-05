package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.Graph;
import ch4.treesandgraphs.implementations.Vertex;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *  
 * @author Aditya Srinivasan
 *
 */
public class RouteBetweenNodes {
    
    private static boolean connected = false;

    // I need to find if there is a route between two nodes. This means that it is possible to reach one node if
    // I start from the other. Since this is a directed graph, there may be a route from node 1 to node 2, but not
    // the other way around (think of the easiest example of A -> B).
    
    // So, let's assume that the order of the method parameters matters, and we are checking whether there is a route
    // from the first node specified to the second node specified
    
    // If we do a traversal (DFS/BFS) starting at node 1, then if we eventually hit node 2, we can break and return true
    // If we get to the end of the traversal without hitting node 2, we can return false
    
    // So, which is better? To get through all nodes, it may be simpler to use DFS. We aren't told to find the shortest path,
    // so it's not like it would help to search closer or further, it may be that the two nodes are connected through one
    // extremely deep connection in which case DFS would be better. But, it may also be the case that the two nodes are connected
    // as neighbors in which case BFS would be better. Since we don't know, we will pick the simpler implementation: DFS
    
    public static boolean isRoute(Vertex v1, Vertex v2) {
        if(v1 == null || v2 == null) { connected = false; }
        if(v1 == v2) { connected = true; }
        System.out.println(v1.data);
        v1.visited = true;
        for(Vertex neighbor : v1.neighbors) {
            if(!neighbor.visited) {
                isRoute(neighbor, v2);
            }
        }
        return connected;
    }
    
    // Let's test this code with an example of A -> B -> C
    // Assume we input A as v1 and C as v2
    //
    // A.visited = true, B isn't visited so visit it
    //      |_ B.visited = true, C isn't visited so visit it
    //            |_ C == C, so return true
    //
    // If we add some vertex D that isn't connected, then after we get through C,
    // we realize C has no neighbors, and so the call returns false

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
        System.out.println(RouteBetweenNodes.isRoute(v1, v0));
    }
    
    
}