package misc;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    
    public static int LIS(Integer[] A) {
        int n = A.length;
        int[] D = new int[n];
        
        for(int i = 0; i < n; i++) {
            D[i] = 1;
        }
        
        int max = 1;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j]) {
                    D[i] = Math.max(D[j] + 1, D[i]);
                }
            }
        }
        
        System.out.println(Arrays.toString(D));
        
        for(int i = 0; i < n; i++) {
            if(D[i] > max) {
                max = D[i];
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        Integer[] A = new Integer[]{3, 4, -1, 0, 6, 2, 3};
        System.out.println(LIS(A));
    }

}
