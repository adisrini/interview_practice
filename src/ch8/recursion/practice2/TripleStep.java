package ch8.recursion.practice2;

public class TripleStep {
    
    public static int count(int n) {
        if(n <= 0) {
            return 0;
        }
        return 1 + count(n-1) + count(n-2) + count(n-3);
    }
    
    public static int countMemo(int n) {
        int[] memo = new int[n];
        for(int i = 0; i < n; i++) {
            memo[i] = -1;
        }
        return count(n, memo);
    }
    
    private static int count(int n, int[] memo) {
        if(n <= 0) {
            return 0;
        }
        if(memo[n-1] == -1) {
            memo[n-1] = 1 + count(n-1, memo) + count(n-2, memo) + count(n-3, memo);
        }
        return memo[n-1];
    }
    
    public static void main(String[] args) {
        int n = 100;
        
        long start = System.currentTimeMillis();
        countMemo(n);
        long time1 = System.currentTimeMillis() - start;
        System.out.println("Time with memo:    " + time1);
        
        count(n);
        long time2 = System.currentTimeMillis() - (start + time1);
        System.out.println("Time without memo: " + time2);
    }

}
