package ch2.linkedlists.practice;

import java.util.Stack;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

/**
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that
 * the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is
 * the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 * 
 * @author Aditya Srinivasan
 *
 */
public class Intersection {

    public static Node doIntersect(Node h1, Node h2) {
           
        // Assumptions:
        // 1) Singly linked list
        // 2) Don't know the length
        
        // Notes:
        // 1) Lengths don't have to be the same
        
        // Check:
        // 1) if the heads are null
        
        // Example
        //
        // Case 1: Intersection
        // 1) 2 -> 10 -> 4* -> 1 -> 5 -> 7 -> 11
        // 2) 3 -> 4 -> 8 -> 4* -> 1 -> 5 -> 7 -> 11
        //
        // Case 2: No intersection
        // 1) 1 -> 2 -> 3 -> 4
        // 2) 5 -> 1 -> 4 -> 3
        
        // One thing we realize is that if there is an intersection, then the last two nodes will be
        // exactly the same by reference. So, we can traverse the lists and get to the tails and compare
        // them.
        
        // This helps us identify if there is an intersection, but now we have to find the intersecting node
        // itself.
        
        // When we are traversing the lists, we can add nodes to stacks
        // If there is an intersection, we can pop off nodes from each stack and compare if they're the same
        // The moment they aren't, we return the Node seen before that
        
        Node c1 = h1; Node c2 = h2;
        
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        
        while(c1.next != null || c2.next != null) {
            if(c1.next != null) {
                s1.push(c1);
                c1 = c1.next;
            }
            if(c2.next != null) {
                s2.push(c2);
                c2 = c2.next;
            }
        }
        
        // Now, c1 and c2 are at the tails and the stacks have the linked lists
        
        if(c1 != c2) return null;       // if they aren't the same, there's no intersection so we return null.
        
        // set the prevs to the top of each stack since we are guaranteed at least the tails are the same (the
        // length of the intersecting list is at least 1)
        Node prev1 = s1.pop();
        @SuppressWarnings("unused")
        Node prev2 = s2.pop();
        
        while(!s1.isEmpty() && !s2.isEmpty()) {
            Node n1 = s1.pop();
            Node n2 = s2.pop();
            if(n1 != n2) {
                return prev1;
            }
            prev1 = n1;
            prev2 = n2;
        }
        
        return null;
        
        // Instead of using stacks, we can just find the lengths from our first traversal. Then we know how much
        // longer (if at all) one of the lists is. We can "get a headstart" so that the pointers are in the same
        // position relatively, and then traverse until the nodes are the same. When they are, we return.
    
    }
    
    public static void main(String[] args) {
        
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
        
        System.out.println(Intersection.doIntersect(ll1.head, ll2.head).data);
        
    }

}
