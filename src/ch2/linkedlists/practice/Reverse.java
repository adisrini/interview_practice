package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

public class Reverse {
    
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static Node reverseRecurse(Node node) {
        if(node == null || node.next == null) {
            return node;
        }
        Node next = node.next;      // store next node
        node.next = null;           // break cycle
        
        Node rest = reverseRecurse(next);   // reverse the rest of the list
        next.next = node;
        
        return rest;
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        LinkedList ll = new LinkedList();
        ll.add(n1);
        ll.add(n2);
        ll.add(n3);
        ll.add(n4);
        ll.add(n5);
        ll.add(n6);
        
        ll.print();
        
        Node n = Reverse.reverseRecurse(n1);
        while(n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        
    }

}
