package misc;

public class LongestCommonSubsequence {
    
    public static int LCS(String s1, String s2) {
        int[][] LCS = new int[s1.length()][s2.length()];
        return LCS(s1, s2, s1.length(), s2.length(), LCS);
    }
    
    private static int LCS(String s1, String s2, int i, int j, int[][] LCS) {
        if(i == 0 || j == 0) {
            return 0;
        }
        if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + LCS(s1, s2, i - 1, j - 1, LCS);
        } else {
            return Math.max(LCS(s1, s2, i - 1, j, LCS), LCS(s1, s2, i, j - 1, LCS));
        }
    }
    
    public static void main(String[] args) {
        System.out.println(LCS("adityasrini", "dytan"));
    }
    
}
