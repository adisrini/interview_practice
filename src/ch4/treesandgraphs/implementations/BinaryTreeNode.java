package ch4.treesandgraphs.implementations;

public class BinaryTreeNode<T> {

    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    
    public BinaryTreeNode(T data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
    
}
