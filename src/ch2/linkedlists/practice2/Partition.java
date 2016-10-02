package ch2.linkedlists.practice2;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

public class Partition {
    
    static Node partition(Node head, int p) {
        if(head == null || head.next == null) {
            return head;
        }
        Node nhead = head;
        Node ntail = head;
        Node curr = head.next;
        
        while(curr != null) {
            Node next = curr.next;
            if(curr.data < p) {
                curr.next = nhead;
                nhead = curr;
            } else {
                ntail.next = curr;
                ntail = curr;
            }
            curr = next;
        }
        ntail.next = null;
        return nhead;
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(3);
        ll.add(5);
        ll.add(8);
        ll.add(5);
        ll.add(10);
        ll.add(2);
        ll.add(1);
        
        ll.print();
        
        Node n = partition(ll.head, 5);
        
        LinkedList ll2 = new LinkedList();
        ll2.add(n);
        
        ll2.print();
    }

}
