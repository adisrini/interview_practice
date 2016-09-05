package ch3.stacksqueues.practice;

import java.util.EmptyStackException;

/**
 * Describe how you could use a single array to implement three stacks.
 * 
 * @author Aditya Srinivasan
 *
 */
public class ThreeInOne {

    //
    // To implement the functionality of a stack, we must be able to add nodes and remove them in a LIFO manner.
    // We must also be able to check if the stack is empty, and be able to peek if we want
    //
    // We can implement this with an array in a few ways
    // 1) Partition the array into three equal parts (1 | 2 | 3) where each part represents its own stack.
    // 2) Interleave the array to represent the three stacks (123123123123123123123123123123 . . . ) so that each stack
    //    is interspersed throughout the array
    // 
    // Approach (1) is more straightforward, but can cause problems if the stack needs to be grown. We will need to move
    // elements from stacks 2 and 3 over in order to maintain our contiguous partitions
    //
    // Approach (2) is less straightforward but makes it more extensible. Adding more capacity just means doubling the size
    // of the array and continuing our interleaving pattern.
    //
    // We can instantiate an array of some given capacity and have three counters representing the position of each stack
    // These counters will be initialized at 0, 1, and 2 for stacks 1, 2, and 3 respectively.
    //
    // Every time an element is added to a particular stack, array[counterOfThatStack] = element, and then counterOfThatStack
    // is incremented by 3. If counterOfThatStack is out of bounds when we're adding, we double the size of the array, copy
    // the items over, and then perform our add.
    //
    // Every time an element is removed from a particular stack, we return array[counterOfThatStack], and then counterOfThatStack
    // is decremented by 3 (if it is not less than 3, since that means we just removed the first item)
    //
    // Every time a peek is called on a stack, we just return array[counterOfThatStack]
    //
    // Finally, if we want to check if a stack is empty, we just check if the counter is less than 3 (0, 1, or 2).
    //
    // If the stacks have size A, B, and C, then the space complexity is O(max(A, B, C)). In the worst case, our array is
    // only filled every third element if two stacks are empty
    //
    // The time complexity is O(1) for addition, O(1) for removal, O(1) for peeking, and O(1) for checking emptiness. In the
    // worst case, an add may be O(N) since items need to be copied over. However, this is amortized and the time complexity
    // is just O(1) on average.
    //
    
    // let's try and generalize our problem for not just three, but any number of stacks.
    
    private int numberOfStacks;
    private int[] stacks;
    private Counters counters;
    
    public ThreeInOne(int capacityOfEachStack, int numberOfStacks) {
        this.numberOfStacks = numberOfStacks;
        stacks = new int[capacityOfEachStack*numberOfStacks];
        counters = new Counters(numberOfStacks);
    }
    
    public class Counters {
        
        private int[] counters;
        
        public Counters(int number) {
            counters = new int[number];
            for(int i = 0; i < number; i++) {
                counters[i] = i;
            }
        }
        
        public int getCounter(int index) {
            return counters[index];
        }
        
        public void decrement(int index) {
            counters[index] -= numberOfStacks;
        }
        
        public void increment(int index) {
            counters[index] += numberOfStacks;
        }
    
    }
    
    public void push(int data, int stackNumber) {
        counters.increment(stackNumber);
        if(stackNumber >= stacks.length) {
            expand();
        }
        stacks[counters.getCounter(stackNumber)] = data;
    }
    
    public void expand() {
        int[] copy = new int[stacks.length*2];
        for(int i = 0; i < stacks.length; i++) {
            copy[i] = stacks[i];
        }
        stacks = copy;
    }
    
    public int pop(int stackNumber) {
        if(isEmpty(stackNumber)) throw new EmptyStackException();
        int data = stacks[counters.getCounter(stackNumber)];
        counters.decrement(stackNumber);
        return data;
    }
    
    public int peek(int stackNumber) {
        if(isEmpty(stackNumber)) throw new EmptyStackException();
        return stacks[counters.getCounter(stackNumber)];
    }
    
    public boolean isEmpty(int stackNumber) {
        return counters.getCounter(stackNumber) < numberOfStacks;
    }
    
}
