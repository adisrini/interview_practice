package ch8.recursion.practice2;

import java.util.HashSet;
import java.util.Set;

public class Coins {
    
    public static void count(int n) {
        Set<String> set = new HashSet<>();
        count(n, 0, 0, 0, 0, set);
        System.out.println(set + "\n" + set.size());
    }
    
    private static void count(int rem, int q, int d, int n, int p, Set<String> set) {
        if(rem < 0) {
            return;
        }
        if(rem == 0) {
            String combo = q + "|" + d + "|" + n + "|" + p;
            if(!set.contains(combo)) {
                set.add(combo);
            }
            return;
        }
        count(rem - 25, q + 1, d, n, p, set);
        count(rem - 10, q, d + 1, n, p, set);
        count(rem - 5, q, d, n + 1, p, set);
        count(rem - 1, q, d, n, p + 1, set);
    }
    
    public static int count2(int n) {
        return count(n, 25);
    }
    
    private static int count(int n, int denom) {
        int next_denom = 0;
        
        switch(denom) {
        case 25:
            next_denom = 10;
            break;
        case 10:
            next_denom = 5;
            break;
        case 5:
            next_denom = 1;
            break;
        case 1:
            return 1;
        }
        
        int ways = 0;
        
        for(int i = 0; i * denom <= n; i++) {
            ways += count(n - i*denom, next_denom);
        }
        
        return ways;
    }
    
    public static void main(String[] args) {
        int n = 60;
        
        long start = System.currentTimeMillis();
        count(n);
        long time1 = System.currentTimeMillis() - start;
        
        System.out.println(count2(n));
        long time2 = System.currentTimeMillis() - (start + time1);
        
        System.out.println("1st: " + time1);
        System.out.println("2nd: " + time2);

    }

}
