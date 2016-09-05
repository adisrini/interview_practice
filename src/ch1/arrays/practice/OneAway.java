package ch1.arrays.practice;

/**
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a
 * character. Given two strings, write a function to check if they are one edit (or zero edits) away. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class OneAway {

    public static boolean oneAway(String s1, String s2) {

    // There are three kinds of edits, and each uniquely affects the relationship between the two strings.
    // Insertion means s2 is longer than s1 by 1 character, deletion means s2 is shorter than s1 by 1 character,
    // replacement means s1 and s2 are the same length. In reality, insertion and deletion are the same thing just
    // from two different perspectives, so we can treat them the same.
    //
    // we can immediately reject any pair of strings that differ by more than 1 character in LENGTH. we can also immediately
    // check if the two are the same, and return true if they are.
    //
    // if there is a difference of 1, we must make sure that character counts differ in one regard only
    // so, we can cycle through the larger string and increment counts in an int array where indices represent a character’s ASCII value
    // then cycle through the smaller string and decrement counts in the same array
    // we must have NO negatives (we don’t even need to check the array after, we can just check this as we go)
    // ex: pales, pale -> p, a, l, e, s are all 1
    //             -> p, a, l, e are all 0, s is 1
    // ex: pales, bale -> p, a, l, e, s are all 1
    //             -> b is -1, RETURN FALSE
    // essentially, the smaller string can’t have a letter than the bigger string doesn’t have
    // this will work for both insertion and deletion
    // we could also use a boolean array where we flip values and make sure only one is `true` afterwards.
    // we can also do the checks within one loop but it may not be more optimal
    //
    // As for replacement, we can do a similar process. We want to make sure that only one character differs
    // so we cycle through one string and increment counts in an array, then do the same for the other string
    // we must have EXACTLY one negative number, any more mean that we have more than one letter different from the original
    // ex: pales, bales —> p, a, l, e, s are all 1
    //              -> b is -1, a, l, e, s are all 0
    // ex: pales, paleo -> p, a, l, e, s are all 1
    //              -> p, a, l, e, are all 0, o is -1, s is 1
    // ex: pales, baleo -> p, a, l, e, s are all 1
    //              -> b, is -1, a, l, e, are all 0, o is -1, p is 1, o is 1
    //
    // so, our algorithm:   if pairs differ by more than 1 character, return false.
    //              if pairs are equal, return true.
    //              if difference of +/- 1, make sure character counts differ in one regard only
    //              if no difference, make sure only one character differs
    //
    
        if(Math.abs(s1.length() - s2.length()) > 1) return false;
        if(s1.equals(s2)) return true;

        if(Math.abs(s1.length() - s2.length()) == 1) {
            return isInsertionOrDeletion(s1, s2);
        } else {
            return isReplacement(s1, s2);
        }

    }

    private static boolean isInsertionOrDeletion(String s1, String s2) {

        int[] chars = new int[256];
        String shorter, longer;
        if(s1.length() > s2.length()) {
            longer = s1; shorter = s2;
        } else {
            longer = s2; shorter = s1;
        }

        for(int i = 0; i < longer.length(); i++) {
            int index = longer.charAt(i);
            chars[index]++;
        }
        for(int i = 0; i < shorter.length(); i++) {
            int index = shorter.charAt(i);
            chars[index]--;
            if(chars[index] < 0) {
                return false;
            }
        }
        return true;

    }

    private static boolean isReplacement(String s1, String s2) {

        int[] chars = new int[256];
        boolean oneNegative = false;

        for(int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i);
            chars[index]++;
        }
        for(int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i);
            chars[index]--;
            if(chars[index] < 0) {
                if(!oneNegative) oneNegative = true;
                else return false;
            }
        }
        return true;

    }

    // TEST CASES
    // pales, ales: goes to insertion/deletion method -> p, a, l, e, s values in chars are all 1
    //                                   -> a, l, e, s values in char are all 0, no negatives seen, so returns true
    // pales, paless: goes to insertion/deletion method -> p, a, l, e, values in char are all 1, s is 2
    //                                     -> p, a, l, e, values in char are all 0, s is 1, no negatives, so returns true
    // pales, bales: goes to replacement method -> p, a, l, e, s all 1
    //                              -> b is -1, a, l, e, s are 0, returns true
    // pppp, ppbb: goes to replacement method -> p is 4
    //                              -> p is 2, b is -2, two negatives seen so returns false
                

    public static void main(String[] args) {
        System.out.println(OneAway.oneAway("pales", "bales") == true);
        System.out.println(OneAway.oneAway("pale", "ple") == true);
        System.out.println(OneAway.oneAway("pales", "pale") == true);
        System.out.println(OneAway.oneAway("pale", "bake") == false);
        System.out.println(OneAway.oneAway("pale", "pales") == true);
    }
    
    
}
