package misc;

import java.util.Arrays;

public class Knapsack {
    
    public static int[][] knapsack(int[] v, int[] w, int n, int W) {
        int[][] V = new int[n + 1][Math.abs(W) + 1];
        for(int i = 0; i < W; i++) {
            V[0][i] = 0;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= Math.abs(W); j++) {
                if(Math.abs(w[i - 1]) <= j) {
                    V[i][j] = Math.max(Math.abs(V[i - 1][j]), v[i - 1] + Math.abs(V[i - 1][j - Math.abs(w[i - 1])]));
                } else {
                    V[i][j] = V[i - 1][j];
                }
            }
        }
        
        return V;
    }
    
    public static double max(double[] A) {
        double T = A[0];
        double S = 0;
        for(int i = 1; i < A.length; i++) {
            if(T * A[i] > T + A[i]) {
                T *= A[i];
            } else {
                S = A[i];
                for(int j = i + 1; j < A.length; j++) {
                    if(S * A[j] > S + A[j]) {
                        
                    } else {
                        
                    }
                }
                T += S;
            }
        }
        return T;
    }
    
    public static void main(String[] args) {
//        int[] v = new int[]{10, 40, 30, 50};
//        int[] w = new int[]{-5,   -4,  -6,  -3};
//        int[][] ret = knapsack(v, w, v.length, -10);
//        for(int i = 0; i < ret.length; i++) {
//            for(int j = 0; j < ret[i].length; j++) {
//                System.out.print(String.format("%4d", ret[i][j]));
//            }
//            System.out.println();
//        }
        double max = max(new double[]{2, 3, 0.5, 2});
        System.out.println(max);
    }

}
