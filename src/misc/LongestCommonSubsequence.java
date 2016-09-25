package misc;

public class LongestCommonSubsequence {
    
    public static int LCS(Object[] A, Object[] B) {
        int n = A.length;
        int m = B.length;
        int[][] LCS = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if(A[i - 1].equals(B[j - 1])) {
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        
        return LCS[n][m];
    }
    
    public static void main(String[] args) {
        System.out.println(LCS(new Character[]{'a', 'd', 'i', 't', 'y', 'a'}, new Character[]{'d', 'y', 't', 'a', 'f', 'a'}));
    }
    
}
