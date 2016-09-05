package ch3.stacksqueues.practice;

import ch3.stacksqueues.implementations.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack,
 * but you may not copy the elements into any other data structure (such as an array). The stack supports the following
 * operations: push, pop, peek, and isEmpty. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class SortStack {

    // We are allowed to use another stack, which will help us a lot
    //
    // Let's think of some sample input: 5 2 1 9 3 6 4
    // We will want that stack to look like this: {9, 6, 5, 4, 3, 2, 1} <- top
    //
    // How do we do this?
    //
    // So let's imagine we have our normal stack, and then some temporary buffer stack called buff
    //
    // We'll initially add our first value to the stack. There's nothing to sort since there's only one element, so
    // we don't do anything special.
    //
    // We add our second element now. It's a 2. Intuitively, we know that the 2 should stay above the 5 to stay at the top
    // of the stack, so we don't do anything special.
    // We follow the same thought for adding 1.
    //
    // Now, when we add 9 something different happens. 9 should appear at the bottom, intuitively, since it's bigger than anything
    // in the stack already. Here's where we use our buffer. We compare 9 to the top of the stack. If 9 is bigger than it, we
    // pop it off and add it to the buffer. We now have this: stack {5, 2}, buff{1}
    // We do the same thing, and we move 2 to the buffer: stack {5}, buff{1, 2}
    // Again, moving 5 to the buffer: stack{}, buff{1, 2, 5}
    // Now, since there's nothing in the stack, we can add our 9. Then, we transfer everything over to the stack again, giving us
    // {9, 5, 2, 1}. This is sorted! We continue this logic for all other additions
    //
    // A remove or peek just requires us to remove or peek from the our sorted stack, and we query emptiness on this stack as well.
    //
    // One thing to note: imagine the pathological stream 1, 2, 3, 4, 5, 6, 7, 8, 9
    // Each time, we are required to transfer all of our items to the buffer, add our element, then transfer back.
    //
    // Is there a way we can minimize all of this work? After all, we can keep our stack segmented as long as the user is not
    // calling pops or removes. Only when they do that should we actually transfer back to the stack and pop.
    //
    // Okay, so suppose a user inputs 1
    //
    // If they input 2, we move 1 to the buffer and 2 onto the stack, then we leave it there.
    //
    // If they input 3, we move 2 to the buffer and 3 onto the stack, then we leave it there
    //
    // This works for the pathological stream, and reduces the amount of work. But, what about the even more pathological stream
    // 1 2 3 4 5 6 7 8 9 0
    //
    // In this case, by the time we get to 0, we'll have 9 on the stack, and buff {1, 2, 3, 4, 5, 6, 7, 8} <-
    //
    // How will we know if 0 is a minimum? Keeping track of stack minimums requires a whole other stack. We won't, and we may end
    // up wasting time transferring things from the buffer to the stack, then going through our original algorithm.
    //
    // BUT, we would do this anyways, right? Earlier, we were transferring back and forth every time. Now, we're only transferring
    // if the element being added is smaller than the sole element on the stack. Essentially, our stack now holds the maximum. This
    // saves us if the next element is a new maximum, but costs us a little more if we're adding a new minimum. In our original design,
    // The opposite was true. So which is more common? New minimums or new maximums? It's hard to say, depends on the usage. If we're
    // choosing arbitrarily, our original design is better since it's more consistent and does not require many special case logic.
    
    private Stack<Integer> stack;
    private Stack<Integer> buff;
    
    public SortStack() {
        stack = new Stack<>();
        buff = new Stack<>();
    }
    
    public void push(int data) {
        while(!stack.isEmpty() && data > peek()) {
            buff.push(stack.pop());
        }
        stack.push(data);
        while(!buff.isEmpty()) {
            stack.push(buff.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    public static void main(String[] args) { 
        SortStack ss = new SortStack();
        ss.push(4);
        ss.push(2);
        ss.push(6);
        ss.push(1);
        ss.push(9);
        ss.push(5);
        ss.push(3);
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.isEmpty());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.isEmpty());
    }
    

}
