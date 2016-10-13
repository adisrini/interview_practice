package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StoreLocations {
    
    static class Node {
        Object value;
        boolean store = false;
        List<Node> children = new ArrayList<>();
        
        Node(Object value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return this.value.toString();
        }
    }
    
    static Set<Node> placed = new HashSet<>();
        
    public static int placeStores(Node root) {
        return f(root);
    }
    
    private static int f(Node node) {
        if(node.children.isEmpty()) {
            return 0;
        }
        int g1 = g(node);
        int g2 = g(node.children);
        if(g1 <= g2) {
            placed.add(node);
        } else {
            placed.addAll(node.children);
        }
        return Math.min(g1, g2);
    }
    
    private static int f(List<Node> nodes) {
        int total = 0;
        for(Node node : nodes) {
            total += f(node);
        }
        return total;
    }
    
    private static int g(Node node) {
        if(node.children.isEmpty()) {
            return 1;
        }
        return 1 + f(node.children);
    }
    
    private static int g(List<Node> nodes) {
        int total = 0;
        for(Node node : nodes) {
            total += g(node);
        }
        return total;
    }
    
    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        
        A.children.add(B);
        B.children.add(C);
        C.children.add(D);
        C.children.add(E);
        
        System.out.println(placeStores(A));
        System.out.println(placed);
    }

}
