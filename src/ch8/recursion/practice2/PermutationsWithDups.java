package ch8.recursion.practice2;

import java.util.Arrays;

public class PermutationsWithDups {
    
    public static void perms(char[] string) {
        Arrays.sort(string);
        perm(string, 0);
    }
    
    private static void perm(char[] string, int index) {
        if(index == string.length) {
            System.out.println(new String(string));
            return;
        }
        char lastChar = 0;
        perm(string, index + 1);
        lastChar = string[index];
        
        for(int i = index + 1; i < string.length; i++) {
            if(string[i] == lastChar) {
                continue;
            } else {
                lastChar = string[i];
            }
            swap(string, index, i);
            perm(string, index + 1);
            swap(string, index, i);
        }
    }
    
    private static void swap(char[] string, int a, int b) {
        char temp = string[a];
        string[a] = string[b];
        string[b] = temp;
    }
    
    public static void main(String[] args) {
        perms(new char[]{'a', 'b', 'a'});
    }

}
