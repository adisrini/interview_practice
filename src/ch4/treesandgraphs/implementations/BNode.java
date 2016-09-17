package ch4.treesandgraphs.implementations;

public class BNode<T> {

    public T data;
    public BNode<T> left;
    public BNode<T> right;
    
    public BNode(T data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
    
}
