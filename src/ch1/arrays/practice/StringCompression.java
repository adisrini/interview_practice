package ch1.arrays.practice;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters. For example,
 * the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can assume the string has only uppercase
 * and lowercase letters (a - z). 
 * 
 * @author Aditya Srinivasan
 *
 */
public class StringCompression {

    public static String compress(String s) {

        // assumptions: uppercase and lowercase letters treated differently? assume yes.
        // brute force algorithm: keep track of current letter being traversed
        //                  traverse through the String and if that letter is seen again, increment the counter
        //                  if another letter is seen, add the letter followed by the count to a String, then reset counter to zero
        //                  compare length of compressed string to length of original string, and return the shorter of the two
        // this is O(N) time complexity, and O(N) space complexity, since a new String is being formed
        // we can’t really do better than O(N) time complexity, but maybe we can do it in place to bring it to O(1) space complexity?
        // since Strings are immutable, we’d have to create another char[] anyways, which would require O(N) space, so let’s stick with
        // our algorithm and see if we can improve later
        // 

        StringBuilder compressed = new StringBuilder();
        char current = s.charAt(0);
        int num_times_seen = 1;

        int num_consec = 1;

        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(current == c) {
                num_times_seen++;
            } else {
                compressed.append(current);
                compressed.append(num_times_seen);
                current = c;
                num_times_seen = 1;
                num_consec++;
            }
        }
        
        compressed.append(current);
        compressed.append(num_times_seen);

        return (2*num_consec >= s.length()) ? s : compressed.toString();

        // TESTS
        // aaabbccc -> current = a, num_times_seen = 1, num_consec = 1
        //       -> c = a, current = a, so num_times_seen = 2, num_consec = 1
        //       -> c = a, current = a, so num_times_seen = 3, num_consec = 1
        //       -> c = b, current = a, so go to the else statement: add “a3” to the compression, current = ‘b’, num_times_seen = 1, num_consec = 2
        //       -> c = b, current = b, so num_times_seen = 2, num_consec = 2
        //       -> and so on…
        // we end up with a3b2c3, which is 6 long, compared to aaabbccc, which is 8 long, so we return a3b2c3.
        //
        // we note that the compressed string is simply 2*x, where x is the number of continuous streams of letters. we can do a quick pass once
        // before the algorithm to check what this number is, compare it to the original string length, and make a decision then
        // actually, we could do this in the normal for loop
        // this means we don’t have to do the extra work to find lengths (which doesn’t really affect runtime since it’s O(N) anyways, but it’s a small optimization)
            
    }
    
    public static void main(String[] args) {
        System.out.println(StringCompression.compress("aabcccccaaa"));
    }

}
