package ch8.recursion.practice;

public class PaintFill {
    
    public static void fill(int[][] grid, int r, int c, int newColor) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return;
        }
        fill(grid, r, c, newColor, grid[r][c]);
    }
    
    private static void fill(int[][] grid, int r, int c, int newColor, int oldColor) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != oldColor) {
            return;
        }
        grid[r][c] = newColor;
        fill(grid, r + 1, c, newColor, oldColor);
        fill(grid, r - 1, c, newColor, oldColor);
        fill(grid, r, c + 1, newColor, oldColor);
        fill(grid, r, c - 1, newColor, oldColor);
    }
    
    public static void main(String[] args) {
        int[][] grid = {{2, 2, 2, 2, 2, 2, 2},
                        {2, 2, 2, 1, 2, 2, 2},
                        {2, 1, 1, 1, 1, 2, 2},
                        {2, 1, 1, 1, 2, 2, 2},
                        {2, 1, 1, 1, 2, 2, 2},
                        {2, 2, 1, 1, 2, 2, 2},
                        {2, 2, 2, 2, 2, 2, 2}};
       
        fill(grid, 1, 3, 0);
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}
