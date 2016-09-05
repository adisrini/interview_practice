package ch5.bitmanipulation.practice;

public class FlipBitToWin {
    
    // 1. find the number of bits required to represent the number (the length of the sequence)
    // 2. go through from range i = 0 -> length and if that bit is a zero, flip it
    // 3. check the current longest range of 1s
    // 4. continue and return max value
    //
    // step 1 is a matter of finding the log base 2 of the number. this can be implemented using the change-of-base formula
    // step 2 is done by using a for loop and finding the bit at that index
    //        -> this can be done by shifting 1 leftwards by i and performing logical AND on the number
    //        -> if its a one just skip to step 4, otherwise continue to step 3
    // step 3 is the hardest part, we'll get back to this
    // step 4 is just a matter of tracking the max value. the max should initially be set to 0, and updated if any sequence is
    //        -> encountered larger than that
    //
    // so how do we find the longest sequence of 1s within a binary representation? naively, we could convert the number
    // to a string and cycle through this, but that is fairly costly, especially since we are already cycling through
    // the entire length of the sequence, resulting in O(logN * logN) time. Even if we cycle through the number itself, it
    // is pretty costly. but since we are already cycling through the number, could we utilize this?
    //
    // if we store the value of each bit in a hashtable after iterating through once, then we may be able to look ahead
    // while we are iterating for real the second time around. this may improve time, but requires O(logN) space now.
    //
    // 100111110001110
    
    public static int flip(int number) {
        int length = log(number, 2);
        if(number == 0) return 1;       // the max length will just be flipping a single zero
        int max = 0;
        for(int i = 0; i < length; i++) {
            if(getBit(number, i)) {
                continue;
            } else {
                int seqLength = longestSequenceOf1s(setBit(number, i));
                if(seqLength > max) {
                    max = seqLength;
                }
            }
        }
        return max;
    }
    
    private static int log(int x, int base) {
        return (int) Math.ceil(Math.log(x)/Math.log(base));
    }
    
    private static boolean getBit(int x, int i) {
        return ((x & (1 << i)) != 0);
    }
    
    private static int setBit(int x, int i) {
        // to set a bit at index i to 1, we must OR the entire number with 000100...00 where 1 is in the ith place
        // this will maintain the other digits, and flip the ith to a 1
        return x | (1 << i);
    }
    
    private static int longestSequenceOf1s(int number) {
        int length = log(number, 2);
        int runningMax = 0;
        int currentLength = 0;
        for(int i = 0; i < length; i++) {
            if(getBit(number, i)) {
                currentLength++;
            } else {
                if(currentLength > runningMax) {
                    runningMax = currentLength;
                }
                currentLength = 0;
            }
        }
        return runningMax;
    }
    
    public static void main(String[] args) {
        System.out.println(flip(1775));
    }

}
