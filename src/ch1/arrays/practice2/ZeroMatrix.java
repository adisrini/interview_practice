package ch1.arrays.practice2;

public class ZeroMatrix {
    
    static int[][] zero(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        boolean firstRowHasZero = zeroInFirstRow(matrix, C);
        boolean firstColHasZero = zeroInFirstCol(matrix, R);
        
        for(int r = 1; r < R; r++) {
            for(int c = 1; c < C; c++) {
                if(matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }
        
        
        for(int r = 1; r < R; r++) {
            if(matrix[r][0] == 0) {
                setRowToZero(matrix, r, C);
            }
        }
        
        for(int c = 1; c < C; c++) {
            if(matrix[0][c] == 0) {
                setColToZero(matrix, c, R);
            }
        }
        
        if(firstRowHasZero) {
            setRowToZero(matrix, 0, C);
        }
        if(firstColHasZero) {
            setColToZero(matrix, 0, R);
        }
        
        return matrix;
    }
    
    private static void setRowToZero(int[][] matrix, int r, int C) {
        for(int c = 0; c < C; c++) {
            matrix[r][c] = 0;
        }
    }
    
    private static void setColToZero(int[][] matrix, int c, int R) {
        for(int r = 0; r < R; r++) {
            matrix[r][c] = 0;
        }
    }
    
    private static boolean zeroInFirstCol(int[][] matrix, int R) {
        for(int r = 0; r < R; r++) {
            if(matrix[r][0] == 0) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean zeroInFirstRow(int[][] matrix, int C) {
        for(int c = 0; c < C; c++) {
            if(matrix[0][c] == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 4, 2, 1, 6},
                                   {5, 3, 2, 7, 9},
                                   {3, 3, 6, 3, 9},
                                   {2, 3, 4, 1, 5}};
                                   
        int[][] zeroed = zero(grid);
        
        for(int r = 0; r < zeroed.length; r++) {
            for(int c = 0; c < zeroed[r].length; c++) {
                System.out.print(String.format("%4d", zeroed[r][c]));
            }
            System.out.println();
        }
    }

}
