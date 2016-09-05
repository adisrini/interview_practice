package ch3.stacksqueues.implementations;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<T> implements Stackable<T> {
    
    public static class Node<T> {
        
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
        }
        
    }
    
    public Node<T> top;
    public int size = 0;

    @Override
    public void push(T data) {
        Node<T> t = new Node<T>(data);
        t.next = top;
        top = t;
        size++;
    }

    @Override
    public T pop() {
        if(top == null) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        List<T> stack = new ArrayList<T>(size);
        string.append("{");
        while(!isEmpty()) {
            T data = pop();
            stack.add(data);
            string.append(data + ", ");
        }
        for(int i = stack.size() - 1; i >= 0; i--) {
            push(stack.get(i));
        }
        string.append("}");
        return string.toString();
    }
    

}
