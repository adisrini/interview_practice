package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

public class Intersection2 {

    public Node intersection(Node h1, Node h2) {
        int length1 = 0;
        int length2 = 0;
        Node tail1 = null;
        Node tail2 = null;
        Node c1 = h1, c2 = h2;
        while(c1.next != null || c2.next != null) {
            if(c1.next != null) {
                length1++;
                c1 = c1.next;
            } else {
                tail1 = c1;
            }
            if(c2.next != null) {
                length2++;
                c2 = c2.next;
            } else {
                tail2 = c2;
            }
        }
        if(tail1 != tail2) {
            return null;
        }
        Node longerListHead = null;
        if(length1 < length2) {
            longerListHead = h2;
        } else if(length1 > length2) {
            longerListHead = h1;
        }
        if(longerListHead != null) {
            Node curr = longerListHead;
            for(int k = 0; k < Math.abs(length2 - length1); k++) {
                curr = curr.next;
            }
        }
        Node p1 = h1, p2 = h2;
        while(p1 != null || p2 != null) {
            if(p1 == p2) {
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    
    public static void main(String[] args) {
        Intersection2 i = new Intersection2();
        
        Node a1 = new Node(2);
        Node a2 = new Node(9);
        Node b1 = new Node(3);
        Node b2 = new Node(4);
        Node b3 = new Node(10);
        
        LinkedList ll1 = new LinkedList();
        ll1.add(a1);
        ll1.add(a2);
        ll1.add(b2);
        ll1.add(b3);
        
        LinkedList ll2 = new LinkedList();
        ll2.add(b1);
        ll2.add(b2);
        ll2.add(b3);
        b3.next = null;
        
        ll1.print();
        ll2.print();
        
        System.out.println(i.intersection(ll1.head, ll2.head));
    }
    
}
