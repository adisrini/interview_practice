package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    
    public static List<Character> lcs(String a, String b) {
        
        List<Character> lcs = new ArrayList<>();

        int M = a.length();
        int N = b.length();

        int[][] LCS = new int[M + 1][N + 1];

        for(int r = 0; r <= M; r++) {
          LCS[r][0] = 0;
        }
        
        for(int c = 0; c <= N; c++) {
          LCS[0][c] = 0;
        }

        int max = 0;
        
        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
                if(LCS[i][j] > max) {
                    lcs.add(a.charAt(i - 1));
                    max = LCS[i][j];
                }
            }
        }

        return lcs;

    }
    
    public static void main(String[] args) {
        System.out.println(lcs("aditya srinivasan", "daytime"));
    }

}
