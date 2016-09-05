package ch1.arrays.implementations.linkedlist;

public interface INode<T> {

    public INode<T> next();
    
    public T data();
    
    public void setNext(INode<T> node);
    
}
