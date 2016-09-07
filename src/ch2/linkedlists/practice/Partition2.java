package ch2.linkedlists.practice;

import java.util.Random;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

public class Partition2 {
    
    public Node partition(Node head, int x) {
        Node leftHead = null, leftTail = null, rightHead = null, rightTail = null;
        if(head.data < x) {
            leftHead = head;
            leftTail = head;
        } else {
            rightHead = head;
            rightTail = head;
        }
        Node curr = head.next;
        while(curr != null) {
            if(curr.data < x) {
                if(leftHead == null) {
                    leftHead = curr;
                    leftTail = curr;
                } else {
                    leftTail.next = curr;
                    leftTail = curr;
                }
            } else {
                if(rightHead == null) {
                    rightHead = curr;
                    rightTail = curr;
                } else {
                    rightTail.next = curr;
                    rightTail = curr;
                }
            }
            curr = curr.next;
        }
        leftTail.next = rightHead;
        rightTail.next = null;
        return leftHead;
    }
    
    public static void main(String[] args) {
        Partition2 p = new Partition2();
        Random r = new Random();
        LinkedList ll = new LinkedList();
        for(int i = 0; i < 14; i++) {
            ll.add(r.nextInt(10));
        }
        ll.print();
        Node pHead = p.partition(ll.head, 5);
        while(pHead != null) {
            System.out.print(pHead.data + " -> ");
            pHead = pHead.next;
        }
    }

}
