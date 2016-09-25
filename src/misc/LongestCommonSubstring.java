package misc;

public class LongestCommonSubstring {
    
    public static int LCS(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] M = new int[n + 1][m + 1];
        int max = 0;
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) {
                    M[i][j] = 0;
                } else if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    M[i][j] = 1 + M[i - 1][j - 1];
                    if(M[i][j] > max) {
                        max = M[i][j];
                    }
                } else {
                    M[i][j] = 0;
                }
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(LCS("aditya", "dit adit"));
    }

}
