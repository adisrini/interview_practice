package misc;

import ch2.linkedlists.implementations.LinkedList.Node;

public class ReverseLL {
    
    public static Node reverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        head.next = null;
        Node rest = reverse(next);
        next.next = head;
        
        return rest;
    }
    
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
//        Node t = n0;
//        while(t != null) {
//            System.out.println(t.data);
//            t = t.next;
//        }
        
        Node curr = reverse(n0);
        
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

}
