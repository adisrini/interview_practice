package ch3.stacksqueues.practice;

import java.util.EmptyStackException;

import ch3.stacksqueues.implementations.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum
 * element? Push, pop and min should all operate in 0(1) time. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class StackMin {

    // We are constrained by time complexity, which constrains the possible algorithms we can use.
    // 
    // Push and pop are already O(1) time, so it's just a question of how to get min in O(1) time
    //
    // As we add elements to the stack, we can record what the running minimum is. For example,
    // if we add the numbers 6, 3, 9, 1, 2, 8, 0 in that order, we'll get the min to be:
    // * 6 (since 6 < POS_INFINITY)
    // * 3 (since 3 < 6)
    // * 3 (since 3 < 9)
    // * 1 (since 1 < 3)
    // * 1
    // * 1
    // * 0
    //
    // So, each time we must compare the currently added item to the running minimum
    //
    // This works for adding, but what about for popping? If we pop off the stack, we remove 0
    // However, our min still reads 0. How do we get our min to then become 1? Well, if we just remember
    // the minimum BEFORE our current minimum, we can recover.
    //
    // So, in our example above, if we pop off the number zero, we just remember that the minimum before
    // that was 1
    //
    // So, we can create a 2 element array: [oldMin, newMin]
    // Each time we add, we update the two as necessary: if the current element is a new min, we set oldMin = newMin,
    // and newMin = currentElement
    //
    // Each time we pop, we update the two as necessary as well: if the popping element is the newMin, we set newMin = oldMin,
    // but then what does oldMin become? We've forgotten about the previous mins
    //
    // So, we could use another stack to hold the minimums
    //
    // Every time we add a new minimum (this counts if the new number is equal to the minimum), pop it onto the stack
    // Every time we pop a number equal to the top of the minimum stack, we pop from the minimum stack too
    //
    // Let's see how this looks
    //
    //   ACTUAL STACK               MINIMUM STACK
    //     ~EMPTY~                    ~EMPTY~    
    //
    //        6                          6
    //       
    //        3                          3
    //        6                          6
    //
    //        9         
    //        3                          3
    //        6                          6
    //
    //        1     
    //        9                          1
    //        3                          3
    //        6                          6
    //
    //        1
    //        1                          1
    //        9                          1
    //        3                          3
    //        6                          6
    //
    //
    // Now, if we pop off 1, then we also pop off from the minimum stack since the values are equal, so our minimum
    // then becomes 1 again. If we pop off the next one, then we pop off from the minimum stack again, so our minimum
    // is now 3. Note, we must add to the minimum stack even if the values are the same, because if we didn't we'd get
    // that our new minimum is 3 when we pop off our first 1.
    // 
    // This algorithm is O(n) space, where n is the number of "new" minimums found when progressing in order. In the best
    // case, this will be O(1) space, but in the worst case it may be O(N)
    
    private Stack<Integer> myStack;
    private Stack<Integer> myMinStack;
    
    public StackMin() {
        myStack = new Stack<>();
        myMinStack = new Stack<>();
    }
    
    public void push(Integer data) {
        myStack.push(data);
        if(myMinStack.isEmpty()) {
            myMinStack.push(data);
        } else {
            if(data <= min()) {
                myMinStack.push(data);
            }
        }
    }
    
    public Integer pop() {
        if(myStack.isEmpty()) throw new EmptyStackException();
        Integer data = myStack.pop();
        if(data.equals(myMinStack.peek())) {
            myMinStack.pop();
        }
        return data;
    }
    
    public Integer min() {
        if(myMinStack.isEmpty()) throw new EmptyStackException();
        return myMinStack.peek();
    }
    
    public static void main(String[] args) {
        StackMin s = new StackMin();
        s.push(6);
        System.out.println(s.min());
        s.push(9);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(6);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(3);
        System.out.println(s.min());
        s.push(1);
        System.out.println(s.min());
        s.push(0);
        System.out.println(s.min());
        System.out.println("POPPING");
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
    }
    
    
}
