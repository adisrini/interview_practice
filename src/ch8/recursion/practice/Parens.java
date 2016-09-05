package ch8.recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class Parens {
    
    public static List<String> parens(int n) {
        List<String> results = new ArrayList<>();
        parens("", n, n, results);
        return results;
    }
    
    private static void parens(String prefix, int leftRem, int rightRem, List<String> results) {
        if (leftRem == 0 && rightRem == 0) {
            results.add(prefix);
            return;
        }
        if (rightRem < leftRem) {
            return;
        }
        if (leftRem > 0) {
            parens(prefix + "(", leftRem - 1, rightRem, results);
        }
        if (rightRem > 0) {
            parens(prefix + ")", leftRem, rightRem - 1, results);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(parens(3));
    }

}
