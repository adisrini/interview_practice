package ch1.arrays.implementations.linkedlist;

public class LinkedList<T> implements ILinkedList<T> {

    private INode<T> head;
    private INode<T> tail;
    
    public LinkedList(INode<T> head) {
        this.head = head;
        this.tail = head;
    }
    
    @Override
    public void add(T element) {
        INode<T> node = new Node<T>(null, element);
        tail.setNext(node);
        tail = node;
    }

    @Override
    public T get(int index) {
        int count = 0;
        INode<T> current = head;
        while(current != null) {
            if(count == index) {
                return current.data();
            }
            current = current.next();
            count++;
        }
        return null;
    }
    
    @Override
    public T get(T element) {
        INode<T> current = head;
        while(current != null) {
            if(element.equals(current.data())) {
                return current.data();
            }
            current = current.next();
        }
        return null;
    }

    @Override
    public INode<T> getHead() {
        return head;
    }

    @Override
    public int size() {
        int count = 0;
        INode<T> current = head;
        while(current != null) {
            current = current.next();
            count++;
        }
        return count;
    }

    @Override
    public boolean delete(int index) {
        INode<T> current = head;
        INode<T> prev = null;
        int count = 0;
        if(index == 0) {
            head = current.next();
            return true;
        }
        while(current != null) {
            if(count == index) {
                if(current == tail) {
                    prev = tail;
                }
                prev.setNext(current.next());
                return true;
            }
            prev = current;
            current = current.next();
            count++;
        }
        return false;
    }

    @Override
    public boolean delete(T element) {
        INode<T> current = head;
        INode<T> prev = null;
        if(element.equals(head.data())) {
            head = current.next();
            return true;
        }
        while(current != null) {
            if(element.equals(current.data())) {
                prev.setNext(current.next());
                return true;
            }
            prev = current;
            current = current.next();
        }
        return false;
    }
    
    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        INode<T> current = head;
        while(current != null) {
            builder.append(current.data() + " -> ");
            current = current.next();
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

}
