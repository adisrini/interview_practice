package ch4.treesandgraphs.implementations;

public class BinaryTree<T> {
    
    public BNode<T> root;
    
    public void addLeft(BNode<T> parent, BNode<T> child) {
        parent.left = child;
    }
    
    public void inorder(BNode<T> root) {
        if(root != null) {
            inorder(root.left);
            visit(root);
            inorder(root.right);
        }
    }
    
    public void preorder(BNode<T> root) {
        if(root != null) {
            visit(root);
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public void postorder(BNode<T> root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            visit(root);
        }
    }
    
    private void visit(BNode<T> node) {
        System.out.println(node.data);
    }
    

}
