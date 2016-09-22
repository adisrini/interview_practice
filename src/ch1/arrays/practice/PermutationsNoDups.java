package ch1.arrays.practice;

import java.util.Arrays;

public class PermutationsNoDups {
    
    public static void perm(char[] string) {
        perm(string, 0);
    }
    
    private static void perm(char[] string, int index) {
        if(index == string.length) {
            System.out.println(Arrays.toString(string));
            return;
        }
        
        for(int i = index; i < string.length; i++) {
            swap(string, index, i);
            perm(string, index + 1);
            swap(string, index, i);
        }
    }
    
    private static void swap(char[] string, int i, int j) {
        char temp = string[i];
        string[i] = string[j];
        string[j] = temp;
    }
    
    public static void main(String[] args) {
        perm(new char[]{'a', 'b', 'c'});
    }

}
