package ch8.recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class PermutationsNoDups {
    
    public static List<String> getPerms(String string) {
        List<String> permutations = new ArrayList<>();
        getPerms("", string, permutations);
        return permutations;
    }
    
    private static void getPerms(String prefix, String remainder, List<String> results) {
        int len = remainder.length();
        
        if(len == 0) {
            results.add(prefix);
            return;
        }
        
        for(int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1);
            char c = remainder.charAt(i);
            getPerms(prefix + c, before + after, results);
        }
    }
    
    // TEST:
    
    // "abc"
    // getPerms("", "abc", results) -> i = 0, before = "", after = "bc", char = "a"
    //          getPerms("a", "bc", results) -> i = 0, before = "", after = "c", char = "b"
    //                  getPerms("ab", "c", results) -> i = 0, before = "", after = "", char = "c"
    //                          getPerms("abc", "", results) -> results.add("abc")
    //
    //          getPerms("a", "bc", results) -> i = 1, before = "b", after = "", char = "c"
    //                  getPerms("ac", "b", results) -> i = 0, before = "", after = "", char = "b"
    //                          getPerms("acb", "", results) -> results.add("acb")
    
    public static void main(String[] args) {
        System.out.println(getPerms("abc"));
    }

}
