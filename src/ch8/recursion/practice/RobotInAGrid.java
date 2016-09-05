package ch8.recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class RobotInAGrid {
    
    static class Coordinate {
        
        int x;
        int y;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }
    
    private static List<Coordinate> path = new ArrayList<>();
    private static List<Coordinate> pathMemo = new ArrayList<>();

    
    public static boolean path(char[][] grid) {
        return path(grid, 0, 0);
    }
    
    private static boolean path(char[][] grid, int r, int c) {
        if(grid == null) {
            return false;
        }
        if(r >= grid.length || c >= grid[0].length) {
            return false;
        }
        if(grid[r][c] == 'X') {
            return false;
        }
        path.add(new Coordinate(r, c));
        if(r == grid.length - 1 && c == grid[0].length - 1) {
            return true;
        }
        return path(grid, r+1, c) || path(grid, r, c+1);
    }
    
    public static boolean pathMemo(char[][] grid) {
        Boolean[][] memo = new Boolean[grid.length][grid[0].length];
        return pathMemo(grid, 0, 0, memo);
    }
    
    private static boolean pathMemo(char[][] grid, int r, int c, Boolean[][] memo) {
        if(grid == null) {
            return false;
        }
        if(r >= grid.length || c >= grid[0].length) {
            return false;
        }
        if(grid[r][c] == 'X') {
            return false;
        }
        pathMemo.add(new Coordinate(r, c));
        if(r == grid.length - 1 && c == grid[0].length - 1) {
            return true;
        }
        if(memo[r][c] == null) {
            memo[r][c] = pathMemo(grid, r+1, c, memo) || pathMemo(grid, r, c+1, memo);
        }
        return memo[r][c];
    }
    
    public static void main(String[] args) {
        char[][] grid = {{'O', 'O', 'O', 'X', 'O', 'O', 'O'},
                         {'X', 'X', 'O', 'O', 'X', 'X', 'X'},
                         {'O', 'O', 'X', 'O', 'O', 'O', 'X'},
                         {'O', 'O', 'O', 'X', 'O', 'O', 'X'},
                         {'O', 'O', 'O', 'X', 'O', 'O', 'X'},
                         {'O', 'O', 'O', 'O', 'X', 'O', 'O'},
                         {'O', 'O', 'O', 'O', 'O', 'O', 'O'},};
        long start = System.currentTimeMillis();
        System.out.println(path(grid));
        System.out.println(path);
        long time1 = System.currentTimeMillis() - start;
        System.out.println(pathMemo(grid));
        System.out.println(pathMemo);
        long time2 = System.currentTimeMillis() - (start + time1);
        System.out.println("no memo: " + time1);
        System.out.println("with memo: " + time2);
        
    }

}
