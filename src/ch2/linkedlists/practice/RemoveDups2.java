package ch2.linkedlists.practice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

public class RemoveDups2 {
    
    public Node removeDups(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Set<Integer> seen = new HashSet<Integer>();
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            if(seen.contains(curr.data)) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                seen.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    
    public Node removeDups2(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        Node prev = head;
        while(slow != null && slow.next != null) {
            while(fast != null) {
                if(fast.data == slow.data) {
                    prev.next = fast.next;
                    fast = prev.next;
                } else {
                    prev = fast;
                    fast = fast.next;
                }
            }
            slow = slow.next;
            prev = slow;
            fast = slow.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        RemoveDups2 rd2 = new RemoveDups2();
        Random r = new Random();
        LinkedList ll = new LinkedList();
        for(int i = 0; i < 10; i++) {
            ll.add(r.nextInt(10));
        }
        ll.print();
        rd2.removeDups2(ll.head);
        ll.print();
    }

}
