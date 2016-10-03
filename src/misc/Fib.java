package misc;

public class Fib {
    
    public static int fibM(int N) {
        return fibM(N, new Integer[N + 1]);
    }
    
    private static int fibM(int N, Integer[] memo) {
        if(N == 0 || N == 1) {
            return N;
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
    
    public static int fibI(int N) {
        if(N <= 1) {
            return N;
        }
        int[] memo = new int[N + 1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i < memo.length; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }
    
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fibM(6));
        System.out.println(fibI(6));
    }

}
