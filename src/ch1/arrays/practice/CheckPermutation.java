package ch1.arrays.practice;

/**
 * Given two strings, write a method to decide if one is a permutation of the other. 
 * 
 * @author Aditya Srinivasan
 * 
 */
public class CheckPermutation {

    public static boolean isPermutation(String s1, String s2) {

        // Initial thoughts:
        // 1. if s1 and s2 are not the same length, then they can’t be permutations, so we can just check that first
        // 2. s1 and s2 must have the same number of characters in order to be permutations
        // 
        // brute force: cycle through characters in s1, and increment corresponding indices in int[]
        //           do the same thing for s2, then cycle through both and make sure all are the same
        //          if n is the length of s1 (and s2), then this is O(n) time complexity, and
        //          O(n) space complexity
        //          we can’t get better than O(n) time complexity, since we will need to touch every letter in at least one string
        //          we could reduce space complexity to O(1), but then we would have to iterate through the other string
        //          while going through the current string, so time complexity goes up to O(n^2)
        // 
        // let’s look at some examples
        // 1. “abcdefg”, “gabdcfe”
        // the natural way of doing it is by running in a nested-like loop
        //
        // we could reduce the need for one of the arrays by decrementing values from the first array when we go through the second string
        // then when we go through the array at the end, we just make sure all of the values are 0
        //
        // assuming we are using a Unicode character set, and not an ASCII set:

        if(s1.length() != s2.length()) {
            return false;
        }
        
        if(s1.equals(s2)) {
            return true;
        }
    
        int[] counts = new int[256];
    
        for(int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i);
            counts[index]++;
        }

        // NOTE: could do the following within the loop above, but this is easier to read
        for(int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i);
            counts[index]--;
        }

        for(int count : counts) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        System.out.println(CheckPermutation.isPermutation("abc", "cba"));
        System.out.println(CheckPermutation.isPermutation("hello", "goodbye"));
        System.out.println(CheckPermutation.isPermutation("ya", "no"));
        System.out.println(CheckPermutation.isPermutation("racecar", "racecar"));
        System.out.println(CheckPermutation.isPermutation("good", "dogo"));
        System.out.println(CheckPermutation.isPermutation("pots", "stop"));
    }

}