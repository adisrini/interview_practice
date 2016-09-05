package ch3.stacksqueues.implementations;

public interface Queueable<T> {
    
    public void add(T data);
    
    public T remove();
    
    public T peek();
    
    public boolean isEmpty();

}
