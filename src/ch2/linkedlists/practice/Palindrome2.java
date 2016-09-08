package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

public class Palindrome2 {
    
    public static boolean isPalindrome(Node head) {
        Node head_new = null;
        Node curr = head;
        while(curr != null) {
            Node node = new Node(curr.data);
            node.next = head_new;
            head_new = node;
            curr = curr.next;
        }
        Node c1 = head_new;
        Node c2 = head;
        while(c1 != null || c2 != null) {
            if(c1.data != c2.data) {
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        LinkedList ll = new LinkedList();
        ll.add(n1);
        ll.add(n2);
        ll.add(n3);
        ll.add(n4);
        ll.add(n5);
        System.out.println(Palindrome2.isPalindrome(ll.head));
    }

}
