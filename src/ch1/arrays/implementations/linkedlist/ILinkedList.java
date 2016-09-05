package ch1.arrays.implementations.linkedlist;

public interface ILinkedList<T> {
    
    public void add(T element);
    
    public boolean delete(int index);
    
    public boolean delete(T element);
    
    public T get(int index);
    
    public T get(T element);
    
    public INode<T> getHead();
    
    public int size();
    
    public String print();

}
