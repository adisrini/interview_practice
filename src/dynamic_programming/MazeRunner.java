package dynamic_programming;

public class MazeRunner {
    
    public static int ways_r(int[][] grid) {
        return ways(grid, 0, 0);
    }
    
    private static int ways(int[][] grid, int r, int c) {
        if(r == grid.length || c == grid.length || grid[r][c] == 1) {
            return 0;
        }
        if(r == grid.length - 1 && c == grid.length - 1) {
            return 1;
        }
        return ways(grid, r + 1, c) + ways(grid, r, c + 1);
    }
    
    public static int ways_i(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        
        int row = memo.length - 1;
        boolean blocked = false;
        for(int col = memo[0].length - 1; col >= 0; col--) {     // initialize bottom row
            if(grid[row][col] == 1) {
                blocked = true;
            } else {
                if(!blocked) {
                    memo[row][col] = 1;
                } else {
                    memo[row][col] = 0;
                }
            }
        }
        
        for(int r = memo.length - 2; r >= 0; r--) {
            for(int c = memo[r].length - 1; c >= 0; c--) {
                if(grid[r][c] != 1) {
                    int right = (c == memo[r].length - 1) ? 0 : memo[r][c + 1];
                    int bottom = memo[r + 1][c];
                    memo[r][c] = right + bottom;
                }
            }
        }
        
        return memo[0][0];
        
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                   {0, 0, 0, 0, 1, 0, 0, 0},
                                   {1, 0, 0, 0, 0, 0, 1, 0},
                                   {0, 0, 0, 0, 0, 1, 0, 0},
                                   {0, 0, 1, 1, 0, 0, 0, 0},
                                   {0, 0, 0, 0, 0, 0, 0, 0},
                                   {0, 1, 0, 0, 1, 0, 1, 0},
                                   {0, 0, 0, 0, 0, 0, 0, 0}};
        int ways_r = ways_r(grid);
        int ways_m = ways_i(grid);
        System.out.println(ways_r);
        System.out.println(ways_m);
    }

}
