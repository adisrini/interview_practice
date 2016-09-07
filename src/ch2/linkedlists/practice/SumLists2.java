package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

public class SumLists2 {
    
    public Node sum(Node h1, Node h2) {
        Node head = null, tail = null;
        int carry = 0;
        Node c1 = h1;
        Node c2 = h2;
        while(c1 != null || c2 != null) {
            int digit1 = (c1 == null) ? 0 : c1.data;
            int digit2 = (c2 == null) ? 0 : c2.data;
            int sum = digit1 + digit2 + carry;
            carry = (sum > 9) ? 1 : 0;
            sum %= 10;
            if(head == null) {
                head = new Node(sum);
                tail = head;
            } else {
                tail.next = new Node(sum);
                tail = tail.next;
            }
            c1 = (c1 == null) ? c1 : c1.next;
            c2 = (c2 == null) ? c2 : c2.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        SumLists2 s = new SumLists2();
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        
        ll1.add(7);
        ll1.add(1);
        ll1.add(6);
        
        ll2.add(0);
        ll2.add(5);
        ll2.add(9);
        ll2.add(2);
        
        ll1.print();
        ll2.print();
        
        Node head = s.sum(ll1.head, ll2.head);
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }

}
