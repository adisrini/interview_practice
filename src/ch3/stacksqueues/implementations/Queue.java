package ch3.stacksqueues.implementations;

import java.util.NoSuchElementException;

public class Queue<T> implements Queueable<T> {
    
    public static class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
        }
    }

    
    public Node<T> first;
    public Node<T> last;
    
    @Override
    public void add(T data) {
        Node<T> t = new Node<T>(data);
        if(first == null) {
            first = t;
            last = t;
            return;
        }
        last.next = t;
        last = t;
    }
    

    @Override
    public T remove() {
        if(first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return data;
    }
    

    @Override
    public T peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }
    

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    
}
