package ch1.arrays.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to O. 
 * 
 * @author Aditya Srinivasan
 *
 */
public class ZeroMatrix {

    public static class Pair<A, B> {

        public A a;
        public B b;
    
        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        // would normally have getters and setters and have fields be private, but for ease of readability and compactness, just going to make them public

    }

    public static void zero(int[][] matrix) {

        // we can’t do it in place, at least not in one pass, since setting the row and column to zero will mess up later values
        // we must also traverse through the entire matrix, since in the worst case, there are no zeroes but we still have to check
        // all cells, so best runtime is O(N^2)
        //
        // we can do it in O(N^2) space complexity too, but there might be a better solution, in two passes
        //
        // algorithm: iterate through original matrix
        //         if encounter a zero, add the row and column number to an ArrayList<Pair<Integer, Integer>>
        //         iterate through original matrix again
        //         if that row/column number is in the ArrayList, populate it with a zero
        //         otherwise, leave it be
        // this is O(z) space complexity, where z is the number of zeroes in the matrix
        // and it is O(N^2) time complexity
        // can we do better space-wise? can we get down to O(1)?
        // this would require some way of keeping track of where zeros are without an external storage of any kind
        // 
        // we can further optimize by counting how many zeros are in the matrix first, then sizing the array list accordingly.
        // this mitigates the doubling of array capacity and maximizes our space efficiency
        // also, if there are no zeros, we just return the original matrix!

        int num_zeros = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    num_zeros++;
                }
            }
        }

        if(num_zeros == 0) return;

        List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>(num_zeros);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    list.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                for(int k = 0; k < list.size(); k++) {
                    if(list.get(k).a == i || list.get(k).b == j) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        // this is actually O(N^2*z) run time, so we can probably do better
        //
        // This solution is O(MNz) time complexity and O(z) space complexity
        // We could sacrifice space for less time, and make it O(MN) time complexity with O(M + N) space complexity
        // Review how to do this

    }
    
    public static void main(String args[]) {
        int[][] test = new int[][]{{0, 1, 2, 3}, 
                                   {1, 2, 3, 4},
                                   {2, 3, 0, 5},
                                   {3, 4, 5, 6}};
        ZeroMatrix.zero(test);
        for(int i = 0; i < test.length; i++) {
            for(int j = 0; j < test.length; j++) {
                System.out.print(String.format("%4d", test[i][j]));
            }
            System.out.println();
        }
    }
}
