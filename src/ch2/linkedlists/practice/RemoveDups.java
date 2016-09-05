package ch2.linkedlists.practice;

import java.util.HashMap;
import java.util.Map;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed? 
 *  
 * @author Aditya Srinivasan
 *
 */
public class RemoveDups {
    
    public static void remove(Node head) {
    
        // we want to remove duplicates from an unsorted linked list
        // we are given access to the head, so we can perform basic traversal
        // brute force algorithm would be to traverse and then for each node you’re on, send another runner
        // down the remaining nodes and remove any if they’re the same as the current one
        // this requires no additional buffers so it is O(1) space complexity, but is O(N^2) time complexity
        // 
        // another way that we can do this is by traversing through the list once and adding the data to a
        // hash table. the key is the data and the value is the frequency
        // then we can iterate one more time and for anything that has a frequency of greater than 1, we
        // delete it from the list and decrement the frequency
        // if we continue this, we will remove duplicates from the linked list

        if(head == null) return;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        Node current = head;

        while(current != null) {    
            if(!map.containsKey(current.data)) {
                map.put(current.data, 1);                           // sets frequency to 1 if doesn’t exist in map yet (unseen)
            } else {
                map.put(current.data, map.get(current.data) + 1);           // sets frequency to frequency+1 if exists in map already
            }
            current = current.next;
        }

        // now we have a frequency table for each element in the linked list
        // iterate through and if it has a frequency greater than 1, delete and decrement frequency
        
        Node curr = head.next;
        Node prev = head;

        while(curr != null) {
            if(map.get(curr.data) > 1) {
                prev.next = curr.next;
                map.put(curr.data, map.get(curr.data) - 1);
            }
            prev = curr;
            curr = curr.next;
        }
        
        // NOTE FOR REVIEW: better way to do this. don't need to do two passes. think about it.

    }

    public static void removeNoBuffer(Node head) {

        // c1   c2
        // 0 -> 1 -> 2 -> 3 -> 4 -> ...

        // c1  prev c2
        // 0 -> 1 -> 2 -> 3 -> 4 -> ...

        // c1        prev  c2
        // 0 -> 1 -> 2 -> 0 -> 4 -> ...

        // c1        prev  c2           
        // 0 -> 1 -> 2 -> 4 -> ...       0

        if(head == null) return;

        Node c1 = head;     // start at head
        Node prev = c1;     // set previous to be whatever is right before c2 (which is head at the beginning of the entire algorithm)
        Node c2 = null;     // start null, doesn’t matter because it’ll be set at the beginning of the loop anyways

        while(c1 != null) {             // loop through c1s
            c2 = c1.next;               // set c2 to node after c1
            while(c2 != null) {         // loop through c2s
                if(c2.data == c1.data) {    // if same as current pointer, remove it
                    prev.next = c2.next;
                } else {
                    prev = c2;
                }
                c2 = c2.next;
            }
            c1 = c1.next;
        }

    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.add(4);
        ll.add(2);
        ll.add(10);
        ll.add(0);
        ll.add(3);
        ll.add(4);
        ll.print();
        RemoveDups.remove(ll.head);
        ll.print();
    }

}
