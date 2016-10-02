package ch1.arrays.practice2;

public class RotateMatrix {
    
    static int[][] rotate(int[][] m) {
        int N = m.length;
        
        for(int layer = 0; layer < N/2; ++layer) {
            int start = layer; int end = N - layer - 1;
            for(int i = start; i < end; ++i) {
                int top = m[start][i];
                m[start][i] = m[end - i + start][start];
                m[end - i + start][start] = m[end][end - i + start];
                m[end][end - i + start] = m[i][end];
                m[i][end] = top;
            }
        }
        
        return m;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4, 5, 6},
                                     {7, 8, 9, 10, 11, 12},
                                     {13, 14, 15, 16, 17, 18},
                                     {19, 20, 21, 22, 23, 24},
                                     {25, 26, 27, 28, 29, 30},
                                     {31, 32, 33, 34, 35, 36}};
        
        matrix = rotate(matrix);
        
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix.length; c++) {
                System.out.print(String.format("%4d", matrix[r][c]));
            }
            System.out.println();
        }
    }

}
