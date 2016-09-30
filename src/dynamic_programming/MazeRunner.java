package dynamic_programming;

public class MazeRunner {
    
    public static int ways(int[][] grid) {
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
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1},
                                   {0, 1, 0},
                                   {0, 0, 0},};
        int ways = ways(grid);
        System.out.println(ways);
    }

}
