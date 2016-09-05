package ch3.stacksqueues.practice;

public interface MyQueue<T> {
    
    public void add(T data);
    
    public T remove();
    
    public T peek();
    
    public boolean isEmpty();

}