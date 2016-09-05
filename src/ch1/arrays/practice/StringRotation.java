package ch1.arrays.practice;

/**
 * Assume you have a method isSubst ring which checks if one word is a substring of another. Given two strings, S1 and S2,
 * write code to check if S2 is a rotation of S1 using only one call to isSubstring (e.g., "waterbottle" is a rotation of 
 * "erbottlewat"). 
 * 
 * @author Aditya Srinivasan
 *
 */
public class StringRotation {

    public static boolean isRotation(String s1, String s2) {

        // If s2 is a rotation of s1, then this means something important
        // Take “waterbottle" and “erbottlewat”. If you concatenate the second string to itself, we get “erbottlewaterbottlewat”
        // Now, we can check whether the first string is inside of this string, which it is in this case.
        // If we take two strings which aren’t substrings, then this won’t happen
        // we must also check if these two strings are the same length. if our first string is “a” and our second is “aa”, then the test will pass but it won’t be true
        // if they’re the same length, and the test passes, then it’s definitely a rotation

        if(s1.length() != s2.length()) return false;

        StringBuilder concat = new StringBuilder(2);
        concat.append(s2);
        concat.append(s2);

        return concat.toString().contains(s1);

        // We use a StringBuilder instead of normal String concatenation to reduce time complexity. With normal string concatenation,
        // Each copy would take N character copies, which would be O(N)
        // With a StringBuilder, insertion is merely O(1), since we know the size is going to be 2 beforehand

    }

    
    public static void main(String[] args) {
        System.out.println(StringRotation.isRotation("erbottlewat", "waterbottle") == true);
        System.out.println(StringRotation.isRotation("taco", "coat") == false);
        System.out.println(StringRotation.isRotation("hi", "goodbye") == false);
        System.out.println(StringRotation.isRotation("racecar", "carrace") == true);
    }


}
