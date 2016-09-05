package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored
 * in reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list. 
 * 
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class SumLists {
    
    static class PartialSum {
        Node sum = null;
        int carry = 0;
    }

    public static Node sum(Node h1, Node h2) {

        // Assumptions:
        // 1) We don’t have the length of the linked lists
        // 2) It is a singly linked list
        // 3) We return a new linked list (don’t overwrite)
        // 4) They aren’t necessarily the same length
        // 5) There are no negative numbers (although this shouldn’t actually change much?)

        // Our best conceivable runtime is O(N) where N is the length of the longer list. This is because we must traverse both lists at least once,
        // in order to know what the numbers to add will be.
        // Similarly, our best conceivable space complexity will be O(N), since the final result will be at least as many digits as the longer list

        // Example:
        //
        // List 1: 5 -> 9 -> 2         (295)
        // List 2: 1 -> 8 -> 1 -> 2   (2181)
        // Sum:    6 -> 7 -> 4 -> 2
        
        // We set some carry-over flag initially false
        // We add the corresponding heads and record if there is overflow (greater than or equal to 10)
        // If so, we use just the last digit (remove the leading 1) as our node and set our flag to true
        // Otherwise, we just set the node to the sum and set our flag to false
        // The next time, if there’s a carry over, we add 1 to our answer and do the same thing
        // We iterate while c1 != null || c2 != null
        // At the beginning of the loop, we check if any of them are null and if so we set its value to zero
        // If not null, we set its value to what it actually is and set it to its ‘next’ at the end of the loop

        if(h1 == null || h2 == null) return null;

        Node head = null; Node tail = null; int carryOver = 0;

        Node c1 = h1; Node c2 = h2;

        while(c1 != null || c2 != null || carryOver == 1) {

            // establish variables
            Node next1;
            Node next2;
            int val1;
            int val2;

            // check which are null and set values accordingly
            next1 = (c1 == null) ? c1 : c1.next;
            next2 = (c2 == null) ? c2 : c2.next;
            val1 = (c1 == null) ? 0 : c1.data;
            val2 = (c2 == null) ? 0 : c2.data;
            
            // at this point, only use val1 and val2 to avoid NPE
            // check carry over and add numbers
            int sum = carryOver + val1 + val2;
            carryOver = (sum >= 10) ? 1 : 0;

            // make sure the sum is just a single digit between 0 and 9
            sum %= 10;

            // set node and add to linked list
            if(head == null) {
                head = new Node(sum);
                tail = head;
            } else {
                Node node = new Node(sum);
                tail.next = node;
                tail = node;
            }

            // proceed
            c1 = next1;
            c2 = next2;
        }

        // TEST
        // List 1: 5 -> 9         (95)
        // List 2: 1 -> 8 -> 2   (281)
        // Sum:    6 -> 7 -> 3

        // 1st iter: head = tail = NULL, carryOver = 0, c1 = 5, c2 = 1, next1 = 9, next2 = 8, val1 = 5, val2 = 1, sum = 0+5+1 = 6, carryOver = 0;, sum = 6, head’s null, so head = new Node(6), tail = head, c1 = 9, c2 = 8
        // 2nd iter: head = tail = Node(6), carryOver = 0, c1 = 9, c2 = 8, next1 = null, next2 = 2, val1 = 9, val2 = 8, sum=0+9+8=17, carryOver=1, sum=7, 6.next = new Node(7), tail = 7, c1 = null, c2 = 2
        // 3rd iter: head = 6, tail = 7, carryOver = 1, c1 = null, c2 = 2, next1 = null, next2 = null, val1 = 0, val2 = 2, sum=1+0+2=3, carryOver=0, sum=3, 7.next = new Node(3), tail = 3, c1 = null, c2 = null

        // end iteration

        // 6    ->    7     ->    3,     where 6 is head
        // checks out
        
        // one thing have not checked is if the last two sum to give a carry over, then we'll have to add 1 to the end
        // so, loop if the carry over is still 1
        
        return head;
        
    }
    
    public static Node sumForward(Node h1, Node h2) {

        // We can’t use the same technique as earlier since we will not know how to match up the different lists if they’re different lengths
        // We must first make a pass through each and find their lengths so that we can pad the shorter one with zeros
        //
        // 3 -> 2 -> 1 -> 4
        // 5 -> 9 -> 8 -> 7
        //
        // Now, it isn’t obvious whether the first two numbers require a carry over, since this depends on the ones after
        // We can solve this in one way: create an array where the indices are 1 if there is a sum that exceeds 10
        // Then, we can look at the index after the current digit to see if we need to add 1 to our number
        // This algorithm is O(N) time but O(N) space because of the array
        // We may be able to do better if we determine the carry overs in place
        //
        // All we need to do is look at the numbers in front of us
        // So, if the numbers in front of each current pointer are not null, we check their sum and if it is greater than 10, we add 1 to our current sums
        //
        // c1 at 3 and c2 at 5 . . . look ahead and see 2 and 9 . . . add them up and get something bigger than 10 . . . so, we add 1 to our sum to get 3 + 5 + 1 = 9
        // continue this until c1 at 4 and c2 at 7 . . . look ahead and see nulls . . . just add them up and take modulo with 10 (their carry over is already accounted for)
        // this requires no buffer, which is good because the buffer is unnecessary: we only need to know about the next at any given time, so why use up all that space?
        //
        // what if the first two add to something greater than 10? if c1 is 6 and c2 is also 6, then our final number will start with a 1 and then proceed
        // so, if our head is null and we encounter an overflow, we create two new nodes and sequence them after each other, otherwise proceed as normal

        if(h1 == null || h2 == null) return null;

        int length1 = 0; int length2 = 0;

        Node t1 = h1; Node t2 = h2;

        while(t1 != null || t2 != null) {
            if(t1 != null) {
                length1++;
                t1 = t1.next;
            }
            if(t2 !=  null) {
                length2++;
                t2 = t2.next;
            }
        }

        // if we’re adding 23 + 161
        // 2 -> 3
        // 1 -> 6 -> 1
        // we’d want the first list to become 0 -> 2 -> 3 so we prepend


        // TODO: bring this out into a new method
        if(length1 < length2) {
            for(int i = 0; i < length2 - length1; i++) {
                Node prefix = new Node(0);
                prefix.next = h1;
                h1 = prefix;
            }
        } else if(length2 < length1) {
            for(int i = 0; i < length1 - length2; i++) {
                Node prefix = new Node(0);
                prefix.next = h2;
                h2 = prefix;
            }
        }
    
        // at this point, we have even lists that are ready to work with. so let’s employ our algorithm

        // Node c1 = h1; Node c2 = h2;

        // int carryOver;

        // while(c1 != null) {          // doesn’t matter which one since both are same length

        //  int nextVal1; int nextVal2;

        //  if(c1.next == null) {       // at this point we’re at the tail, so just assume the ones after are 0s
        //      nextVal1 = 0;
        //      nextVal2 = 0;
        //  } else {
        //      nextVal1 = c1.next.data;
        //      nextVal2 = c2.next.data;
        //  }
            
        //  if(nextVal1
        
        // 
        //  c1 = c1.next;
        //  c2 = c2.next;
        // }

        // realized a flaw in this logic. suppose we have 444 + 556
        //                                   we start at 4 + 5 and look ahead and see 4 + 5, no overflow so just add -> 9
        //                                   but the answer is 1000 . . . , so we actually need to know about all the overflows ahead
        //                                   this can be O(N^2) in the worst case, even if we use a buffer!
        // best way to do it may to be using recursion 

        // Alternatively, we could just convert each linked list to a number, add them, then convert that to a linked list
        // This is O(1) space and O(N) time complexity
        // We wouldn’t even have to worry about lengths
        
        PartialSum sum = addListsHelper(h1, h2);
        
        if(sum.carry == 0) {
            return sum.sum;
        } else {
            Node result = insertBefore(sum.sum, sum.carry);
            return result;
        }


    }
    
    public static PartialSum addListsHelper(Node n1, Node n2) {
        if(n1 == null || n2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }
        
        PartialSum sum = addListsHelper(n1.next, n2.next);
        
        int val = sum.carry + n1.data + n2.data;
        
        Node full_result = insertBefore(sum.sum, val % 10);
        
        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }
    
    public static Node insertBefore(Node node, int data) {
        Node n = new Node(data);
        if(node != null) {
            n.next = node;
        }
        return n;
    }


    public static void main(String[] args) {
        
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        
        ll1.add(9); 
        ll1.add(9);
        ll1.add(9);

        ll2.add(9);
        ll2.add(9);
        ll2.add(9);
        ll2.add(9);
        
        Node head = SumLists.sum(ll1.head, ll2.head);
        
        Node curr = head;
        
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        
        System.out.println("\n");
        
        LinkedList ll3 = new LinkedList();
        LinkedList ll4 = new LinkedList();
        
        ll3.add(4);
        ll3.add(4);
        ll3.add(4);
        
        ll4.add(5);
        ll4.add(5);
        ll4.add(6);
        
        Node h = SumLists.sumForward(ll3.head, ll4.head);
        
        Node c = h;
        
        while(c != null) {
            System.out.print(c.data + " -> ");
            c = c.next;
        }

    }

}
