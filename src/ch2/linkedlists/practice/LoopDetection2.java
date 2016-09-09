package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList.Node;

public class LoopDetection2 {
    
    public static Node detectLoop(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        Node slow = head;
        Node fast = head;
        
        int count = 0;
        
        while(count == 0 || slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
                
        slow = head;
        
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n4;
        
        System.out.println(detectLoop(n1).data);
    }

}
