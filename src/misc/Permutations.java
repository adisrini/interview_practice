package misc;

import java.util.Arrays;

public class Permutations {
    
    // Permutations

    public static void permute(String s) {
        permute(s.toCharArray(), 0);
    }

    private static void permute(char[] s, int index) {
        if(index == s.length) {
            System.out.println(Arrays.toString(s));
        }
        
    for(int i = index; i < s.length; i++) {
        swap(s, i, index);
        permute(s, index + 1);
        swap(s, i, index);
    }   

    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
    public static void main(String[] args) {
        permute("abc");
    }

}
