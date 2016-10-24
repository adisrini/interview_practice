package ch8.recursion.practice;

public class Fibonacci {
    
 // Recursive (no memoization)
    public static int fib_r(int n) {
        if(n <= 1) return n;
        return fib_r(n - 1) + fib_r(n - 2);
    }

    // Recursive (with memoization)
    public static int fib_r_m(int n) {
        if(n <= 1) return n;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        return fib(n, memo);
    }

    private static int fib(int n, int[] memo) {
        if(n <= 1) return memo[n];
        if(memo[n] == 0) {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }

    // Iterative
    public static int fib_i(int n) {
        if(n <= 1) return n;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    // Iterative without space
    public static int fib_i_ns(int n) {
        if(n <= 1) return n;
        int first = 0;
        int second = 1;
        for(int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    
    public static void main(String[] args) {
        int n = 36;
        
        int a = fib_r(n);
        int b = fib_r_m(n);
        int c = fib_i(n);
        int d = fib_i_ns(n);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

}
