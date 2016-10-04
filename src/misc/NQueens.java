package misc;

import java.util.Arrays;

public class NQueens {
    
    private static int ways;
    
    public static void NQ(int size) {
        ways = 0;
        NQ(size, 0, new Integer[size]);
    }
    
    private static int NQ(int size, int row, Integer[] columns) {
        if(row == size) {
            System.out.println(Arrays.toString(columns));
            ways++;
        }
        for(int col = 0; col < size; col++) {
            if(checkValid(columns, row, col)) {
                columns[row] = col;
                NQ(size, row + 1, columns);
            }
        }
        return ways;
    }
    
    private static boolean checkValid(Integer[] columns, int row1, int col1) {
        for(int row2 = 0; row2 < row1; row2++) {
            int col2 = columns[row2];
            
            if(col1 == col2) {
                return false;
            }
            
            int colDistance = Math.abs(col2 - col1);
            int rowDistance = row1 - row2;
            
            if(colDistance == rowDistance) {
                return false;
            }
            
        }
        return true;
    }
    
    public static void main(String[] args) {
        NQ(10);
        System.out.println(ways);
    }

}
