package ch1.arrays.practice;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * @author Aditya Srinivasan
 *
 */
public class IsUnique {


    public boolean isUnique(String string) {

        // create a boolean array of 256 characters (as many as there are ASCII values)
        // cycle through each character in the string
        // for that character’s ASCII value, go to that index in the array and:
        //      if it’s true, return false
        //      if it’s false, set it to true
        // after the loop, return true (if you’re at this stage, then you haven’t seen any duplicates)
        //
        // TIME COMPLEXITY: O(N), where string is N characters long, since we see each character once in the worst case
        // SPACE COMPLEXITY: O(1), since the boolean array will always be the same size

        if(string.length() > 256) {
            return false;
        }
        if(string.length() == 0 || string.length() == 1) {
            return true;
        }

        boolean[] chars = new boolean[256];

        for (int i = 0; i < string.length(); i++) {
            int index = string.charAt(i);
            if(chars[index]) {
                return false;
            }
            chars[index] = true;
        }
        return true;

        // Tests (assume ‘a’ has value of 0 for simplicity)
        // 1. “abalone”: a -> chars will have true at 0 and false everywhere else
        //               b -> chars will have true at 0 and 1, false everywhere else
        //               a -> since chars[0] == true, returns false
        //
        // 2. “age”: a -> chars will have true at 0 and false everywhere else
        //           g -> chars will have true at 0 and 6, false everywhere else
        //           e -> chars will have true at 0, 4, and 6, false everywhere else
        // reach end of loop, and returns true
        //
        // This does exactly what we want
        //
        // NOTE: we can reduce unnecessary work by noting that any string longer than 256 will automatically have repetition,
        // and strings of size 0 and 1 will not have any repetition.

    }

    public static void main(String args[]) {
        IsUnique iu = new IsUnique();
        System.out.println(iu.isUnique("abalonian"));
        System.out.println(iu.isUnique("hello"));
        System.out.println(iu.isUnique("windmill"));
        System.out.println(iu.isUnique("typing"));
        System.out.println(iu.isUnique("bothering"));
        System.out.println(iu.isUnique("faster"));
        System.out.println(iu.isUnique("galactic"));
        System.out.println(iu.isUnique(""));
        System.out.println(iu.isUnique("a"));
    }

}
