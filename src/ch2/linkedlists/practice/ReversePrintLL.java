package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

public class ReversePrintLL {
    
    
    // 1 -> 2
    //
    // print(1) -> print(2) -> print(null)
    // 2 <- 1 <-
    public static void print(Node head) {
        if(head == null) {
            return;
        }
        print(head.next);
        System.out.print(" <- " + head.data);
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        ll.add(n0);
        ll.add(n1);
        ll.add(n2);
        ll.add(n3);
        ll.add(n4);
        ll.add(n5);
        
        ll.print();
        print(ll.head);
    }

}
