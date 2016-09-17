package ch4.treesandgraphs.practice2;

public class CommonAncestor {
    
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        
        Node(int data) {
            this.data = data;
        }
        
        void setLeft(Node left) {
            this.left = left;
            left.parent = this;
        }
        
        void setRight(Node right) {
            this.right = right;
            right.parent = this;
        }
        
        @Override
        public String toString() {
            return String.format("data: %d, left: %d, right: %d", data, (left == null) ? -1 : left.data, (right == null) ? -1 : right.data);
        }
    }
    
    public static Node common(Node root, Node n1, Node n2) {
        int depth1 = depth(root, n1, 0);
        int depth2 = depth(root, n2, 0);
        Node deeper = (depth1 - depth2 > 0) ? n1 : n2;
        Node shallow = (depth1 - depth2 > 0) ? n2 : n1;
        for(int i = 0; i < Math.abs(depth1 - depth2); i++) {
            deeper = deeper.parent;
        }
        while(deeper != shallow) {
            deeper = deeper.parent;
            shallow = shallow.parent;
        }
        return deeper;
    }
    
    private static int depth(Node root, Node n, int level) {
        if(n == null || root == null) {
            return 0;
        }
        if(root == n) {
            return level;
        }
        int downlevel = depth(root.left, n, level + 1);
        if (downlevel != 0)
            return downlevel;
  
        downlevel = depth(root.right, n, level + 1);
        return downlevel;
    }
    
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        
        n0.setLeft(n1);
        n1.setLeft(n2);
        n1.setRight(n3);
        n0.setRight(n4);
        n4.setRight(n5);
        n5.setRight(n6);
        
        System.out.println(common(n0, n1, n5));

    }

}
