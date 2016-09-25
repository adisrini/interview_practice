package misc;

import java.util.Arrays;

public class PermsOfSizeK {
    
    public static void perm(char[] s, int k) {
        perm(s, k, 0);
    }
    
    private static void perm(char[] s, int k, int index) {
        if(index == k) {
            System.out.println(Arrays.toString(s));
            return;
        }
        for(int i = index; i < k; i++) {
            s = swap(s, i, index);
            perm(s, k, index + 1);
            s = swap(s, i, index);
        }
    }
    
    private static char[] swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
        return s;
    }

    public static void main(String[] args) {
        perm(new char[]{'a', 'b', 'c'}, 2);
    }
    
}
