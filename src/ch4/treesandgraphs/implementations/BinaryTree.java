package ch4.treesandgraphs.implementations;

public class BinaryTree<T> {
    
    public BinaryTreeNode<T> root;
    
    public void addLeft(BinaryTreeNode<T> parent, BinaryTreeNode<T> child) {
        parent.left = child;
    }
    
    public void inorder(BinaryTreeNode<T> root) {
        if(root != null) {
            inorder(root.left);
            visit(root);
            inorder(root.right);
        }
    }
    
    public void preorder(BinaryTreeNode<T> root) {
        if(root != null) {
            visit(root);
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public void postorder(BinaryTreeNode<T> root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            visit(root);
        }
    }
    
    private void visit(BinaryTreeNode<T> node) {
        System.out.println(node.data);
    }
    

}
