package ch1.arrays.practice;

public class Diagonals {

    public static boolean sameDiagonals(int[][] grid) {
        int N = grid.length;
        
        for(int diff = 0; diff < N; diff++) {
            Integer diag1 = null;
            Integer diag2 = null;
            for(int r = diff; r < N; r++) {
                int r1 = r;
                int c1 = r - diff;
                int r2 = r - diff;
                int c2 = r;
                if(diag1 == null) {
                    diag1 = grid[r1][c1];
                } else {
                    if(diag1 != grid[r1][c1]) {
                        return false;
                    }
                }
                if(diag2 == null) {
                    diag2 = grid[r2][c2];
                } else {
                    if(diag2 != grid[r2][c2]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{{7, 3, 5, 1}, {2, 7, 3, 5}, {1, 2, 7, 3}, {4, 1, 2, 7}};
        System.out.println(sameDiagonals(grid));
    }
    
}
