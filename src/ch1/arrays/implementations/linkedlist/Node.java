package ch1.arrays.implementations.linkedlist;

public class Node<T> implements INode<T> {

    private INode<T> next;
    private T data;

    public Node(INode<T> next, T data) {
        this.next = next;
        this.data = data;
    }

    @Override
    public INode<T> next() {
        return next;
    }

    @Override
    public void setNext(INode<T> node) {
        this.next = node;
    }

    @Override
    public T data() {
        return data;
    }

}
