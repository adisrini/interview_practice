package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindAllPaths {
    
    static class Vertex {
        String name;
        List<Vertex> neighbors;
        
        public Vertex(String name) {
            this.name = name;
            neighbors = new ArrayList<>();
        }
    }
        
    public static void dfs(Vertex v, Stack<String> stack) {
        if(v != null) {
            stack.push(v.name);
            if(v.neighbors.isEmpty()) {
                System.out.println(stack);
            }
            for(Vertex n : v.neighbors) {
                dfs(n, stack);
            }
            stack.pop();
        }
    }
    
    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        
        A.neighbors.add(B);
        B.neighbors.add(C);
        C.neighbors.add(D);
        C.neighbors.add(F);
        D.neighbors.add(E);
        F.neighbors.add(G);
        G.neighbors.add(E);
        
        dfs(A, new Stack<>());
    }

}
