package ch1.arrays.practice;

/**
 *  Write a method to replace all spaces in a string with '%20: You may assume that the string has sufficient space
 *  at the end to hold the additional characters, and that you are given the "true" length of the string
 *  
 * @author Aditya Srinivasan
 *
 */
public class URLify {

    public static String urlify(char[] url, int length) {
        // we’re given a character array that has enough space at the end to perform this in place
        // since we’re trying to replace every whitespace with %20, we know exactly how long the
        // string will be at the very end (it’ll just be n + 2w where n is the total number of characters
        // and w is the number of whitespaces.
        //
        // “Hello there friend    ”
        // “Hello%20there%20friend”
        //
        // algorithm: cycle through the character array
        //         if it’s a whitespace character, cycle through remaining characters and move them up by 2
        //         write %20 in the current and next two spaces
        //         continue
        // this is O(N^2) since the first loop goes N times, and the second will go through the remainder of the characters
        // we’re not using the “true” length though, we should do that 
        //
        // we can do better by cycling in reverse
        //
        // better algorithm: find length of entire array s
        //               find number of whitespaces: w = (s - l)/2
        //               cycle through array in reverse
        //               every time you find a non whitespace character, push it forward by 2*w
        //               if you find a whitespace character, push it forward by 2*w and replace it and the two spaces ahead with %20
        //              (NOTE: this will be okay since you will have already pushed the stuff in front of it ahead)
        //               continue doing this
        // this uses the length and does the algorithm in place: time complexity is O(N + W) where N is the number of non-space characters
        //
        // are there any checks we can make before we start?
        // if the array length and “true” length are the same, we don’t have to do anything

        int arrayLength = url.length;
        int number_of_whitespaces = (arrayLength - length)/2;
        char[] replace = new char[] {'%', '2', '0'};
        
        if(number_of_whitespaces == 0) {
            return new String(url);
        }

        for(int i = length - 1; i >= 0; i--) {
            char c = url[i];
            if(c != ' ') {
                url[i + 2*number_of_whitespaces] = c;
            } else {
                number_of_whitespaces--;
                for(int j = 0; j < 3; j++) {
                    url[i + 2*number_of_whitespaces + j] = replace[j];
                }
            }
        }

        return new String(url);

    }
    
    public static String urlify2(char[] string, int length) {
        if(string.length == length) {
            return new String(string);
        }
        
        int place = length - 1;
        
        for(int i = string.length - 1; i >= 0; i--) {
            if(string[place] != ' ') {
                // if a regular character, just move it up
                string[i] = string[place];
            } else {
                // if a space, add '%20' and move i down two more
                string[i] = '0';
                string[i-1] = '2';
                string[i-2] = '%';
                i -= 2;
            }
            place--;
        }
        
        return new String(string);
    }
    
    public static char[] toCharArray(String str) {
        char[] c = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            c[i] = str.charAt(i);
        }
        return c;
    }
    
    public static void main(String args[]) {
        System.out.println(URLify.urlify(URLify.toCharArray("Hello, World!  "), 13));
        System.out.println(URLify.urlify(URLify.toCharArray("My name is Aditya      "), 17));
        System.out.println(URLify.urlify(URLify.toCharArray("This!"), 5));
        System.out.println(URLify.urlify(URLify.toCharArray("Yo   lol      "), 8));

        System.out.println(URLify.urlify2(URLify.toCharArray("Hello, World!  "), 13));
        System.out.println(URLify.urlify2(URLify.toCharArray("My name is Aditya      "), 17));
        System.out.println(URLify.urlify2(URLify.toCharArray("This!"), 5));
        System.out.println(URLify.urlify2(URLify.toCharArray("Yo   lol      "), 8));
    }
    
}
