package ch1.arrays.practice;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word
 * or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome
 * does not need to be limited to just dictionary words.
 * 
 * @author Aditya Srinivasan
 *
 */
public class PalindromePermutation {
    
    public static boolean isPalindrome(String string) {
    
        // So, a word can be permuted to form a palindrome if it meets the following condition:
        // All characters appear an even number of times, OR, only one character appears an odd number of times
        // For example, taco cat: ’t’, ‘c’, ‘a’ all appear an even number of times, but ‘o’ appears an odd number of times
        //          abba: ‘a’, and ‘b’ both appear an even number of times
        // This has to be true because imagine having a mirror split a word directly in the middle. If there are an even
        // number of letters in the word, then the mirror will be between two letters (ab|ba), but if there are an odd number
        // of letters in the word, then the mirror will split a character in two. In the case of the former, all characters must
        // appear once on each side of the mirror, which is 2*a where a is how many times they appear on one side, so this is
        // an even number. In the case of the latter, all characters must appear once on each side except the character being split
        // down the middle. It only appears once, so it will appear 2a + 1 times, which is always odd.
        //
        // QUESTIONS: case sensitive? assume no.
        //
        // Using this logic, we can find whether a string is a permutation of a palindrome in a few ways
        // algorithm 1: have an array of booleans, where each cell represents a character in the character set (ASCII or Unicode)?
        //          cycle through the string, and (ignoring whitespace? assume so) find the index of the character
        //          flip the boolean of that character’s index
        //          after, go through the boolean array and add up the number of ‘true’s. A cell should only be ‘true’ if it was
        //              touched an odd number of times, so there should be AT MOST one ‘true’
        //          if the number of ‘true’s is greater than 1, return false, otherwise return true.
        // 
        // TIME COMPLEXITY: O(N), since we touch each character once. We can’t do better than this in this case
        // SPACE COMPLEXITY: O(1), since the array length is always the same
        //
        // algorithm 2: cycle through the string, and for each character, cycle through the other letters and count how many
        //              times it occurs
        //          if it occurs an odd number of times, check whether the flag is triggered. If not, trigger it, if so, return false
        //          keep going
        //
        // TIME COMPLEXITY: O(N^2), since we cycle through each character then simultaneously cycle through the other characters
        // SPACE COMPLEXITY: O(1), but we don’t use an additional data structure this time, just one boolean
        //
        // are there any pre-emptive optimizations we can make immediately?
        // if the string is 0 or 1 characters long, we can return true since it is automatically reversible
        //

        string = string.toLowerCase();
        string = string.replace(" ", "");

        if(string.length() <= 1) {
            return true;
        }
    
        boolean[] chars = new boolean[256];
    
        for(int i = 0; i < string.length(); i++) {
            int index = string.charAt(i);
            chars[index] ^= true;
        }

        int number_of_trues = 0;

        for(boolean b : chars) {
            if(b) number_of_trues++;
            if(number_of_trues > 1) return false;
        }

        return true;

        // TESTS
        // Tcao act: lower case -> tcao act -> get rid of whitespace -> tcaoact
        //      : chars is true at ’t’
        //      : chars is true at ‘c’
        //      : chars is true at ‘a’
        //      : chars is true at ‘o’
        //      : chars is false at ‘a’
        //      : chars is false at ‘c’
        //      : chars is false at ‘t’
        // go through chars and add up trues, only true at ‘o’, so 1 true
        // returns true
        //
        // bleh
        //    : chars is true at ‘b’
        //    : chars is true at ‘l’
        //    : chars is true at ‘e’
        //    : chars is true at ‘h’
        // go through chars and add up trues, we get to 2 trues, so we return false
    }
    
    public static void main(String[] args) {
        System.out.println(PalindromePermutation.isPalindrome("Tact Coa"));
        System.out.println(PalindromePermutation.isPalindrome("Race car"));
        System.out.println(PalindromePermutation.isPalindrome("aBc  D BDa"));
        System.out.println(PalindromePermutation.isPalindrome("Abba is si queenneeq"));
        System.out.println(PalindromePermutation.isPalindrome("Randomness"));
        System.out.println(PalindromePermutation.isPalindrome("That hat"));
        System.out.println(PalindromePermutation.isPalindrome("balloon"));
        System.out.println(PalindromePermutation.isPalindrome(""));
        System.out.println(PalindromePermutation.isPalindrome("z"));
    }

}
