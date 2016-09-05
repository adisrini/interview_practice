package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

/**
 * Implement a function to check if a linked list is a palindrome. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class Palindrome {


    // Assumptions:
    // 1) We don't know the length
    // 2) It is a singly linked list
    // 
    // Initial checks:
    // 1) If the list is null, return true (technically an empty list is a palindrome since it reads the same both ways)
    // 
    // Example:
    // 1 -> 2 -> 3 -> 2 -> 1 : returns true
    // 1 -> 2 -> 3 -> 2 : returns false
    // 1 -> 2 -> 3 -> 1 -> 2 : returns false
    //
    // Brute force: counter from 0 -> length(list)/2
    //              for each iteration, find ith and (N-i)th element and check if they're the same
    //              if ever different, return false
    //              if we get to the end, return true
    // Time complexity: O(N^2)
    // Space complexity: O(1)
    //
    // Alternative: we can create an array of length(list)
    //              transfer the elements to the array
    //              find ith and (N-i)th element and check if they're the same
    //              if ever different, return false
    //              if we get to the end, return true
    // Time complexity: O(N) since only need to iterate through list once then array half a time
    // Space complexity: O(N) since we require an array in order to store our values

    public static boolean isPalindrome(Node head) {
    
        if(head == null) return true;
    
        int size = 0;
        
        Node curr = head;
        
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        
        if(size == 1) return true;
        
        int[] elements = new int[size/2];
        
        int count = 0;
        
        Node current = head;
        
        while(current != null) {
            if(count < size/2) {
                elements[count] = current.data;
            } else {
                int index = size - 1 - count;
                if(index < elements.length && elements[index] != current.data) {
                    return false;
                }
            }
            count++;
            current = current.next;
        }
        
        return true;
        
        // 1 -> 2 -> 3 -> 3 -> 2 -> 1
        // array will be of size 3
        // [1, 2, 3]
        // 6 - 1 - 3 = 2, so is curr.data == elements[2]? yes
        // 6 - 1 - 4 = 1, so is curr.data == elements[1]? yes
        // 6 - 1 - 5 = 0, so is curr.data == elements[0]? yes
        // returns true
        //
        // 1 -> 2 -> 1
        // array will be of size 1
        // [1]
        // 3 - 1 - 1 = 1, so elements[1] is null, skip
        // 3 - 1 - 2 = 0, so elements[0] == curr.data? yes
        // returns true
    
    }
    
    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(5);
        ll.add(4);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        
        System.out.println(Palindrome.isPalindrome(ll.head));
        
    }

}
