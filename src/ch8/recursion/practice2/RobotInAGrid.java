package ch8.recursion.practice2;

import java.util.ArrayList;
import java.util.List;

public class RobotInAGrid {

    static class Coordinate {
        int x;
        int y;
        
        Coordinate(int y, int x) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }
    
    private static List<Coordinate> path;
    
    static boolean findPath(int[][] grid) {
        path = new ArrayList<>();
        return findPath(grid, 0, 0);
    }
    
    private static boolean  findPath(int[][] grid, int r, int c) {
        if(grid == null) {
            return false;
        }
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1) {
            return false;
        }
        Coordinate coord = new Coordinate(r, c);
        path.add(coord);
        if(grid[r][c] == 1) {
            return true;
        }
        return findPath(grid, r + 1, c) || findPath(grid, r, c + 1);
    }
    
    public static void main(String[] args) {
        int[][] grid = {{0, -1, 0, 0, -1},
                        {-1, 0, 0, 0, 0},
                        {0, 0, 0, -1, 0},
                        {0, 0, 0, 0, -1},
                        {0, 0, 0, 0, 1}};
        
        System.out.println(findPath(grid));
        System.out.println(path);
    }
    
}
