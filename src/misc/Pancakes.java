package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pancakes {
    
    class Coordinates {
        List<Coordinate> coords = new ArrayList<>();
        
        boolean contains(int t, int p) {
            for(Coordinate coord : coords) {
                if(coord.time == t && coord.loc == p) {
                    return true;
                }
            }
            return false;
        }
    }
    
    class Coordinate {
        int time;
        int loc;
        
        public Coordinate(int time, int loc) {
            this.time = time;
            this.loc = loc;
        }
        
    }

    
    int pancakes(Coordinates coords, int n, int m) {
        int[][] grid = new int[n + 1][m + 1];
        
        int max = 0;
        
        for(int c = 1; c <= m; c++) {
            for(int r = 1; r <= n; r++) {
                int down = grid[r - 1][c - 1];
                int mid = grid[r][c - 1];
                int up = (r == n) ? 0 : grid[r + 1][c - 1];
                if(coords.contains(c, r)) {
                    grid[r][c] = Math.max(down, Math.max(mid, up)) + 1;
                } else {
                    grid[r][c] = Math.max(down, Math.max(mid, up));
                }
                max = Math.max(max, grid[r][c]);
            }
        }
        
        for(int r = n; r >= 0; r--) {
            System.out.println(Arrays.toString(grid[r]));
        }
        
        return max;
        
    }
    
    public static void main(String[] args) {
        Pancakes p = new Pancakes();
        
        Coordinates coords = p.new Coordinates();
        coords.coords.add(p.new Coordinate(1, 1));
        coords.coords.add(p.new Coordinate(2, 2));
        coords.coords.add(p.new Coordinate(3, 4));
        coords.coords.add(p.new Coordinate(4, 3));
        coords.coords.add(p.new Coordinate(4, 4));
        coords.coords.add(p.new Coordinate(5, 2));
                
        System.out.println(p.pancakes(coords, 5, 5));
    }
    
}
