package ch2.linkedlists.practice;

import ch2.linkedlists.implementations.LinkedList;
import ch2.linkedlists.implementations.LinkedList.Node;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
 * greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements
 * less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need
 * to appear between the left and right partitions. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class Partition {

    public static Node partition(Node node, int partition) {

        // Assumptions: we don’t know the length, and the list is singly-linked, and the list is unsorted (otherwise we wouldn’t have to do anything)
        //
        // How would I do this manually?
        //
        // 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1  [partition = 5]
        //
        // Can create some Node newHead and Node leftTail
        // Go through the list and if the Node is less than the the partition, link it after the tail and make it the new tail
        //                  if the Node is greater than or equal to the partition, link it after the tail
        //
        // What if the first element is greater than the first element? Then we’ll need to make the partition element as the “head” of
        // the right partition instead of the tail of the left partition, but the logic is mostly the same
        //
        // This creates a new list (not in place), but does it in one pass
        // It’s O(N) time complexity and O(N) space complexity
        // Can we do it in O(1) space complexity? Yes if we sort in place with O(N log N) time, this is essentially what we want but over-optimizing
        // by completely sorting, we only want a partial sort
        //
        // Let’s implement our first algorithm
        // 

//        Node newHead = head;
//        Node middle = head;
//        Node newTail = head;
//
//        boolean middleInRight = head.data >= partition;
//
//        Node current = head.next;
//        
//        while(current != null) {
//            System.out.println("CURRENT " + current.data);
//            if(!middleInRight) {                        // so, if we start with something less than the partition (3)
//                if(current.data < partition) {
//                    middle.next = current;          // if our order is 3 -> 4 -> . . ., then this will be true, so 3.next will be 4
//                    System.out.println("MIDDLE NEXT " + current.data);
//                    System.out.println(newHead.data + " " + newHead.next.data + " " + newHead.next.next.data);
//                    middle = current;               // and then middle is set to 4
//                    System.out.println("MIDDLE " + middle.data);
//                } else {
//                    newTail.next = current;          // if our order is 3 -> 6 -> . . ., then this will be true, so 3.next will be 5 and our middle is preserved
//                    System.out.println("New tail is now " + newTail.data + " and points to " + newTail.next.data);
//                }
//                newTail = current;
//                System.out.println("NEWTAIL " + current.data);
//                System.out.println("NEWHEAD " + newHead.data);
//            } else {                                // if we start with something greater than the partition (10)
//                if(current.data < partition) {
//                    current.next = newHead;
//                    newHead = current;
//                } else {
//                    newTail.next = current;
//                    System.out.println("NEWTAIL NEXT " + current.data);
//                    newTail = current;
//                    System.out.println("NEWTAIL " + current.data);
//                }
//            }
//            current = current.next;
//            System.out.println();
//        }
//
//        return newHead;

        // This is a bit complicated, so let’s run through a few tests
        //
        // Case 1: Starts bigger than partition with second element also bigger than partition
        // 10 -> 8 -> 5 -> 3 -> 7 -> 1
        //
        // So, newHead = middle = newTail = head (10)
        // middleInRight is true since 10 >= 5
        // 
        // current starts off at 8
        //
        // 1st iteration: goes to else statement -> 8 >= 5 so it goes to else, newTail now points to 8, so 10 points to 8, and newTail then becomes (8)
        //      10   ->   8
        //     newHead     newTail
        //      middle     current
        //
        // 2nd iteration: goes to else statement -> goes to else, newTail now points to 5, so 8 points to 5, and newTail becomes (5)
        //      10   ->   8   ->   5
        //     newHead          newTail
        //      middle          current
        //
        // 3rd iteration: goes to else statement -> goes to if, current points to middle, so 3 points to 10, and newHead becomes 3
        //      3   ->   10   ->   8   ->   5
        //     newHead                   newTail
        //     current   middle        
        //
        // 4th iteration: goes to else statement -> goes to else, newTail now points to 7, so 5 points to 7, and newTail becomes (7)
        //      3   ->   10   ->   8   ->   5    ->    7
        //     newHead                              newTail
        //             middle                   current
        //
        // 5th iteration: goes to else statement -> goes to if, current points to middle, so 1 points to 10 and newHead becomes 1
        //  THIS ISN’T WHAT WE WANT: we should actually make current point to the newHead, that’ll still maintain our partition

        // It's very buggy, here's the solution
        
        Node head = node;
        Node tail = node;
        
        while(node != null) {
            Node next = node.next;
            if(node.data < partition) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        
        return head;
        
        // This was a very similar algorithm, but it was done much more easily by not caring about the order of things
        
    }
    
    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();
        ll.add(3);
        ll.add(5);
        ll.add(8);
        ll.add(5);
        ll.add(10);
        ll.add(2);
        ll.add(1);
        
        Node head = Partition.partition(ll.head, 5);
        
        Node current = head;
        
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
            
        }
        
    }

}
