package ch2.linkedlists.implementations;

public class LinkedList {
    
    public static class Node {
        
        public Node next;
        public int data;
        
        public Node(int data) {
            this.data = data;
        }
        
    }
    
    public Node head;
    
    public void add(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }
    
    public void add(Node n) {
        if(head == null) {
            head = n;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = n;
    }
    
    public void add(int data, int pos) {
        if(head == null) add(data);
        if(pos == 0) {
            Node node = new Node(data);
            node.next = head;
            head = node;
            return;
        }
        int count = 0;
        Node current = head; Node prev = null;
        while(current != null) {
            if(count == pos) {
                break;
            }
            prev = current;
            current = current.next;
            count++;
        }
        Node node = new Node(data);
        prev.next = node;
        node.next = current;
    }
    
    public void print() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void delete(int pos) {
        if(head == null) return;
        if(pos == 0) {
            head = head.next;
            return;
        }
        int count = 0;
        Node current = head; Node prev = null;
        while(current != null) {
            if(count == pos) {
                break;
            }
            prev = current;
            current = current.next;
            count++;
        }
        prev.next = current.next;
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.add(1);
        ll.add(3);
            ll.print();
        ll.add(2, 2);
            ll.print();
        ll.add(-1, 0);
            ll.print();
        ll.delete(0);
            ll.print();
        ll.delete(2);
            ll.print();
        ll.delete(2);
            ll.print();
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node current = head;
        while(current != null) {
            builder.append(current.data + " -> ");
            current = current.next;
        }
        builder.append("]");
        return builder.toString();
    }

}
