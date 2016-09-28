package misc;

/*
 * Java program to determine if binary tree is
 * height balanced or not
 */

/*
 * A binary tree node has data, pointer to left child,
 * and a pointer to right child
 */
public class Balanced {
    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Height {

        int height = 0;
        int lh = 0; // Height of left subtree
        int rh = 0; // Height of right subtree
    }

    static class BinaryTree {

        Node root;

        /* Returns true if binary tree with root as root is height-balanced */
        boolean isBalanced(Node root, Height height) {
            /*
             * l will be true if left subtree is balanced
             * and r will be true if right subtree is balanced
             */
            boolean l = false, r = false;

            /* If tree is empty then return true */
            if(root == null) {
                height.height = 0;
                return true;
            }

            /* Get the height of left and right sub trees */
            l = isBalanced(root.left, height);
            r = isBalanced(root.right, height);

            /*
             * If difference between heights of left and right
             * subtrees is more than 2 then this node is not balanced
             * so return 0
             */
            if((height.lh - height.rh >= 2) || (height.rh - height.lh >= 2))
                return false;

            /*
             * If this node is balanced and left and right subtrees
             * are balanced then return true
             */
            else
                return l && r;

        }

        /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
        /* returns maximum of two integers */
        int max(int a, int b) {
            return (a >= b) ? a : b;
        }

        /*
         * The function Compute the "height" of a tree. Height is the
         * number of nodes along the longest path from the root node
         * down to the farthest leaf node.
         */
        int height(Node node) {
            /* base case tree is empty */
            if(node == null)
                return 0;

            /*
             * If tree is not empty then height = 1 + max of left
             * height and right heights
             */
            return 1 + max(height(node.left), height(node.right));
        }

        
    }
    
    public static void main(String args[]) {
        Height height = new Height();

        /*
         * Constructed binary tree is
         * 1
         * / \
         * 2 3
         * / \ /
         * 4 5 6
         * /
         * 7
         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.left.left = new Node(8);

        if(tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}