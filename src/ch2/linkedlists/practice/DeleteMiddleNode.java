package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily
 * the exact middle) of a singly linked list, given only access to that node.
 * 
 * @author Aditya Srinivasan
 *
 */
public class DeleteMiddleNode {

    public static void deleteMiddleNode(Node middle) {

        //
        // We do not have access to any previous nodes since it is a LinkedList, so we cannot take the traditional route of prev.next = curr.next
        // 
        // a -> b -> c -> d -> e
        //
        // If we are given access to ‘c’, we must make ‘b’ point to ‘d’
        //
        // We don’t have access to ‘b’, but we can pretend to simulate a deletion by making the node take the identity of the next node, and then “deleting” that one
        //
        // In a two step process, this looks like
        //
        // a -> b -> c -> d -> e
        // a -> b -> d(copy) -> d(orig) -> e
        // a -> b -> d(copy) -> e
        //
        // Edge cases?
        //
        // We are given access to a middle node, so we have no issue

        middle.data = middle.next.data;
        middle.next = middle.next.next;

        // This effectively cuts out middle.next, but we replace middle with middle.next’s data, so it don’t mattah

    }
    
    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();
        
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        
        Node middle = ll.head.next.next;
        
        ll.print();
        
        DeleteMiddleNode.deleteMiddleNode(middle);
        
        ll.print();
        
    }


}
