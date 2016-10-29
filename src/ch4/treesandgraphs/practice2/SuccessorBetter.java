package ch4.treesandgraphs.practice2;

public class SuccessorBetter {
    
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        
        Node(int data) {
            this.data = data;
        }
        
        @Override
        public String toString() {
            return Integer.toString(data);
        }
    }
    
    public static Node successor(Node node) {
        if(node == null) {
            return null;
        }
        if(node.right != null) {
            return leftmostNode(node.right);
        } else {
            Node curr = node;
            Node parent = curr.parent;
            while(parent != null && parent.left != curr) {
                curr = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
    
    private static Node leftmostNode(Node node) {
        Node n = node;
        while(n.left != null) {
            n = n.left;
        }
        return n;
    }
    
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        
        n3.left = n1;   n1.parent = n3;
        n1.left = n0;   n0.parent = n1;
        n1.right = n2;  n2.parent = n1;
        n3.right = n4;  n4.parent = n3;
        n4.right = n6;  n6.parent = n4;
        n6.right = n7;  n7.parent = n6;
        n6.left = n5;   n5.parent = n6;
        
        System.out.println(successor(n2));

    }

}
