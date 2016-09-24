package misc;

public class LongestCommonSubsequence {
    
    public static int LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] LCS = new int[n + 1][m + 1];
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) {
                    LCS[i][j] = 0;
                }
                else if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        
        return LCS[n][m];
    }
    
    public static void main(String[] args) {
        System.out.println(LCS("adityasrini", "dytan"));
    }
    
}
