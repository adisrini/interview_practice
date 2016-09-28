package misc;

public class Fib {
    
    public static int fibM(int N) {
        Integer[] memo = new Integer[N + 1];
        memo[0] = 0;
        memo[1] = 1;
        return fibM(N, memo);
    }
    
    private static int fibM(int N, Integer[] memo) {
        if(N == 0 || N == 1) {
            return memo[N];
        }
        if(memo[N] == null) {
            memo[N] = fibM(N - 1, memo) + fibM(N - 2, memo);
        }
        return memo[N];
    }
    
    public static int fib(int N) {
        if(N == 0 || N == 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }
    
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fibM(6));
    }

}
