package ch1.arrays.practice;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to
 * rotate the image by 90 degrees. Can you do this in place?
 * 
 * @author Aditya Srinivasan
 *
 */
public class RotateMatrix {

    public static int[][] rotate(int[][] original) {
    
        // we need to rotate the image by 90 degrees. this is easy to do if we just instantiate a new matrix
        //
        // j =  0  1  2  3  4  5  6  7  8  9  10  ...
        // i   _________________________________
        // 0   |__|__|__|__|__|__|__|__|__|__|__|
        // 1   |__|__|__|__|__|__|__|__|__|__|__|
        // 2   |__|__|__|__|__|__|__|__|__|__|__|
        // 3   |__|__|__|__|__|__|__|__|__|__|__|
        // 4   |__|__|__|__|__|__|__|__|__|__|__|
        // 5   |__|__|__|__|__|__|__|__|__|__|__|
        // 6   |__|__|__|__|__|__|__|__|__|__|__|
        // 7   |__|__|__|__|__|__|__|__|__|__|__|
        // 8   |__|__|__|__|__|__|__|__|__|__|__|
        // 9   |__|__|__|__|__|__|__|__|__|__|__|
        // 10  |__|__|__|__|__|__|__|__|__|__|__|
        //     |__|__|__|__|__|__|__|__|__|__|__|
        //     |__|__|__|__|__|__|__|__|__|__|__|
        //
        // In order to rotate 90 degrees, pairs (i, j) need to go like this: (0, 0) -> (N, 0), (1, 0) -> (N, 1),
        //                                                  (0, 1) -> (N - 1, 0), (0, 2) -> (N - 2, 0)
        //                                      so, in general: (i, j) -> (i, N - j)
        // So, creating a new NxN matrix, and then doing these transformations would be simple
        // it would be O(N^2) time complexity, and O(N^2) space complexity
        // We can’t get better than that time complexity. We must touch every item in the matrix, and that means N^2 touches
        // The space complexity can be improved, however. We need to preserve rows and perform our transformation
        //
        // We can work from the outside towards the inside
        // So, we go top row, right column, bottom row, left column
        // We store the top row in a temp variable
        // We then set the entire left column to become the top row
        // We then set the entire bottom row to become the left column
        // We then set the entire right column to become the bottom row
        // We then set the temp row (top row) to be the right column
        // Then we move in to the smaller square and continue
        // so our variables will be top row : (0, 0) -> (0, N)
        //                    left  c : (N, 0) -> (0, 0)
        //                   bott row: (N, N) -> (N, 0)
        //                  right c  : (0, N) -> (N, N)
        // then after that, we go: top row : (1, 1) -> (1, N - 1)
        //                  left c : (N - 1, 1) -> (1, 1)
        //                   bott row: (N-1, N-1) -> (N - 1, 1)
        //                   right c  : (1, N-1) -> (N-1, N-1)
        // so if it’s in the form (N - i, N - j), then we’re incrementing i and j
        //
        
//        int N = original.length;
//        
//        for(int i = 0; i < N/2; i++) {
//            int[] top = new int[N - 1 - i];
//            int[] left = new int[N - 1 - i];
//            int[] bottom = new int[N - 1 - i];
//            int[] right = new int[N - 1 - i];
//            for(int j = 0; j < N; j++) {
//                top[j] = original[i][j];
//                left[j] = original[N - j][i];
//                bottom[j] = original[N - i][N - j];
//                right[j] = original[j][N - i];
//            }
//            for(int k = 0; k < N; k++) {
//                original[i][k] = ???
//            }
//        }

        // I couldn’t do this one.
        //
        // the solution:
    
        if(original.length == 0 || original.length != original[0].length) return null;
    
        int n = original.length;
        for(int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first; // basically normalizing, so it’s 0, 1, 2, …
                int top = original[first][i];  // gets the corresponding number in the top row
                
                // left -> top
                original[first][i] = original[last - offset][first];        // gets the corresponding number in the bottom row
                
                // bottom -> left
                original[last - offset][first] = original[last][last - offset];

                // right -> bottom
                original[last][last - offset] = original[i][last];

                // top -> right
                original[i][last] = top;
            }
        }

        return original;

        // Test
        //
        // 0  1  2  3
        // 4  5  6  7
        // 8  9  10 11
        // 12 13 14 15
        //
        // n = 4;
        //
        // layer = 0
        //  -> first = 0
        //  -> last = 4 - 1 - 0 = 3
        //      -> i: 0
        //          -> offset = 0;
        //          -> top = matrix[0][0] = 0
        //          -> matrix[0][0] = matrix[3][0] = 12
        //          -> matrix[3][0] = matrix[3][3] = 15
        //          -> matrix[3][3] = matrix[0][3] = 3
        //          -> matrix[0][3] = 0
        //          so we’ve now switched the corners
        //      -> i: 1
        //          -> offset = 1
        //          -> top = matrix[0][1] = 1
        //          -> matrix[0][1] = matrix[2][0] = 8
        //          -> matrix[2][0] = matrix[3][2] = 14
        //          -> matrix[3][2] = matrix[1][3] = 7
        //          so we’ve now switched the next pieces
        //      -> i: 2
        //          this switches the final pieces, the outside rows have been rotated
        // layer = 1
        //  -> first = 1
        //  -> last = 4 - 1 - 1 = 2
        //      -> i: 1
        //          -> offset = 0
        //          -> top = matrix[1][1] = 9
        //          -> matrix[1][1] = matrix[2][1] = 10
        //          -> matrix[2][1] = matrix[2][2] = 6
        //          -> matrix[2][2] = matrix[1][2] = 5
        //          -> matrix[1][2] = top = 9
        //          this changes the inner grid, completing our rotation
        //
        // fairly confident         
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                System.out.print(String.format("%4d", grid[i][j]));
            }
            System.out.println();
        }
        RotateMatrix.rotate(grid);
        System.out.println();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                System.out.print(String.format("%4d", grid[i][j]));
            }
            System.out.println();
        }
    }

}
