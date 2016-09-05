package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * 
 * @author Aditya Srinivasan
 *
 */
public class KthLast {


    public static Node kthLast(Node head, int k) {

        // Let’s think more about what this means
        // So, if k = 0, we are asked to return the 0th last element, but what if k = 1, isn’t that also the last element?
        // Let’s assume k has to be greater than or equal to 1 and less than or equal to N where N is the number of nodes in the linked list
        // We can make the first check at the beginning and the second check later on
        //
        // We also assume we only have access to the head node, so we can’t start from the tail and traverse backwards
        // One brute force algorithm is to traverse to the end and store that as the tail node, but then we can’t traverse backwards since the linked list is singly linked
        // We may be able to use recursion and work our way up the stack k times in order to find the node
        //
        // Or, we can use the fact that the best run time will only be O(N). We can’t know what the k last will be unless we know how long the list is, so we must traverse the
        // list at least once
        // Another brute force algorithm is to loop through the list and find N
        // Then, we can just loop through the list and stop after N - k counts
        // This is space complexity of O(1) but requires worst case traversal of the list twice, which is just O(N) run time
        // 

        if(k < 1 || head == null) return null;

        Node current = head;
        int N = 0;
        while(current != null) {
            N++;
            current = current.next;
        }
        
        if(k > N) return null;

        Node curr = head;
 
        int count = 0;
        while(curr != null) {
            if(count == N - k) {
                break;
            }
            count++;
            curr = curr.next;
        }

        return curr;

        // For k = N, we will get that count == (N - k) when count = 0, so the while loop will never execute. This returns the head, which is what we want.
        // For k = 1, we will get that count == (N - k) when count = N - 1
        // Imagine a LL of 3 elements, 0, 1, 2, then if k = 1 we expect 2 to be returned
        // when count = 0, curr is the head (0), when count = 1, curr is (1), when count = 2, curr is (2) and we break and return 2, which is what we want
        // For 1 < k < N, we will get valid results by same process
        // For k = 0, we return null
        // For k > N, we return null

        // Is there a way we can do this in one pass?
        // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        // Can’t really think of a way

    }
    
    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();
        
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        
        System.out.println(KthLast.kthLast(ll.head, 3).data);
    }
    

}
