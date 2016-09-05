package ch8.recursion.practice;

import java.util.Arrays;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 *  
 * @author Aditya Srinivasan
 *
 */
public class TripleStep {

    //
    // This is a question of combinations and permutations. We are trying to find how many ways n can be decomposed
    // into a sum of 1, 2, and 3.
    //
    // We start off with n = 0, if this is the case, there are no ways that the child can run up the stairs so we return 0
    // For n = 1, there is only one way the child can run up the stairs: if they take 1 step, so we return 1
    // For n = 2, there are two ways: 1 + 1, or 2, so we return 2
    // For n = 3, there are four ways: 1 + 1 + 1, 2 + 1, 1 + 2, or 3, so we return 4
    // and so on...
    // 
    // If we think about all the paths to the nth step, we could build them off paths to the previous steps. How do we get
    // to the nth step?
    //
    // Going from (n-1)st step and hopping 1
    // Going from (n-2)nd step and hopping 2
    // Going from (n-3)rd step and hopping 3
    //
    // Therefore, we just sum all of these together

    public static int possibleWays(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        return possibleWays(n - 1) + possibleWays(n - 2) + possibleWays(n - 3);
    }
    
    // So let's run through with some test cases
    //
    // n = 0, count = 0
    // n = 1, count = 1
    // n = 2, calls possibleWays(1), possibleWays(0), possibleWays(-1), count = 2
    // n = 3, c++, calls pw(2) c++, pw(1) c++, pw(0), pw(2) calls p(1) c++, pw(0), pw(-1), count = 4
    
    // ALTERNATE SOLUTION: using memoization
    
    public static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }
    
    public static int countWays(int n, int[] memo) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(memo[n] == -1) {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
        }
        return memo[n]; 
    }

    public static void main(String[] args) {
        int val = 3;
        long start = System.currentTimeMillis();
        possibleWays(val);
        long time1 = System.currentTimeMillis() - start;
        int answer = countWays(val);
        long time2 = System.currentTimeMillis() - (time1 + start);
        System.out.println("No memo: " + time1 + "ms");
        System.out.println("Memoize: " + time2 + "ms");
        System.out.println(answer);
    }
    
}
