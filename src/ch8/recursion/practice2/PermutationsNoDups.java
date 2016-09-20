package ch8.recursion.practice2;

/**
 * Permutations without Dups: Write a method to compute all permutations of a string of unique characters.
 * 
 * @author Aditya Srinivasan
 *
 */
public class PermutationsNoDups {
    
    public static void permutate(char[] string) {
        permutate(string, 0, string.length);
    }
    
    private static void permutate(char[] string, int index, int end) {
        if(index == end) {
            System.out.println(new String(string));
            return;
        }
        
        for(int i = index; i < end; i++) {
            swap(string, index, i);
            permutate(string, index + 1, end);
            swap(string, index, i);
        }
    }
    
    private static void swap(char[] string, int a, int b) {
        char temp = string[a];
        string[a] = string[b];
        string[b] = temp;
    }
    
    public static void main(String[] args) {
        permutate(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'}, 2, 6);
    }
    
}
