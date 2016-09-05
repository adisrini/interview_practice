package ch3.stacksqueues.practice;

import java.util.EmptyStackException;

import ch3.stacksqueues.implementations.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * 
 * @author Aditya Srinivasan
 *
 */
public class QueueViaStacks<T> implements MyQueue<T> {

    // We have two stacks and must mimic the function of a queue
    //
    // The class should allow users to add, remove, peek, and query on emptiness in a FIFO manner
    //
    // For example, if the user adds 1, 2, 3, 4 (in that order), then removing (or peeking) should return 1
    //
    // If we use two stacks, we can do this
    //
    // Let's say we add to the first stack: so our first stack looks like {1, 2, 3, 4} <- top
    //
    // If the user then calls peek, or remove, we must convert all the nodes to another stack and then query on that one
    //
    // so the second stack will then be {4, 3, 2, 1} <- top, so we'll peek or remove the 1
    //
    // subsequent removes should also be taken from the same stack
    //
    // what about if these commands are intertwined? For example, user adds 1, 2, 3 to his queue, removes, then adds 4, 5, then removes 4 times
    //
    // he should see: 1, then 2, 3, 4, 5
    //
    // how will we simulate this with two stacks?
    //
    // we add 1, 2, 3 to a stack: {1, 2, 3} <- top
    //
    // when the user removes, we convert to another stack thereby reversing the order: {3, 2, 1} <- top
    // this returns 1, as desired
    //
    // now when the user adds 4 and 5, we can't add onto this stack, otherwise the order will be: {3, 2, 4, 5}, which is out of order
    // instead, when the user wants to add again, we move nodes to the other stack and then add: {2, 3, 4, 5} <- top
    // then when the user removes 4, we convert to other stack, and call remove 4 times: {5, 4, 3, 2} <- top
    // this returns 2, 3, 4, 5.
    //
    // So, essentially we have two stacks: an addStack and a removeStack. All calls to add are to the addStack, and all calls to
    // remove/peek are to the peekStack
    //
    // In our add call, we must check if our addStack is empty, if so, we may have recently performed a remove so all of our nodes
    // will be in the removeStack. So, if our removeStack is not empty, we transfer over and then perform our add. However, if the
    // removeStack is also empty, we must not have any nodes at all, so we can just add to the addStack. If our addStack isn't empty,
    // then we assume we recently performed an add, so we just add to the addStack. We COULD keep some flag to keep track of whether
    // our latest transaction was an add or a remove/peek, but checking if stacks are empty is O(1) anyways, so it's fine to just
    // query emptiness.
    //
    // In our remove call, we must do a similar thing. If removeStack is empty, check if addStack is also empty. If so, throw a
    // EmptyStackException. If addStack is not empty, transfer then remove. If removeStack is not empty, just remove.
    //
    // Our peek call is the same as above, except we peek instead of removing
    //
    // To check whether our queue is empty, we check whether both stacks are empty. At any given time, one stack is always empty,
    // but we have no idea of knowing which. Again, we could use a flag so that we're only checking the relevant stack, but there
    // is little benefit from doing this and it adds unnecessary variables to our algorithm.
    
    private Stack<T> addStack;
    private Stack<T> rmvStack;
    
    public QueueViaStacks() {
        addStack = new Stack<T>();
        rmvStack = new Stack<T>();
    }
    
    @Override
    public void add(T data) {
        if(!rmvStack.isEmpty()) {
            transfer(rmvStack, addStack);
        }
        addStack.push(data);
    }
    
    @Override
    public T remove() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        if(!addStack.isEmpty()) {
            transfer(addStack, rmvStack);
        }
        return rmvStack.pop();
    }
        
    @Override
    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        if(!addStack.isEmpty()) {
            transfer(addStack, rmvStack);
        }
        return rmvStack.peek();
    }
        
    @Override
    public boolean isEmpty() {
        return addStack.isEmpty() && rmvStack.isEmpty();
    }
    
    private void transfer(Stack<T> from, Stack<T> to) {
        while(!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
