package ch8.recursion.practice;

/**
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i]
 * = i. Given a sorted array of distinct integers, write a method to find a
 * magic index, if one exists, in array A.
 *
 * What if the values are not distinct?
 * 
 */
public class MagicIndex {
    
    // do a binary search.
    // if an index is less than the number at that index, search left because nothing to the right will be a match (since distinct)
    // if an index is greater than the number at that index, search right because nothing to the left will be a match
    // if an index is equal to the number at that index, return it.
    //
    // -1 0 2 4 5 8 9 11 13
    //
    // start at 5 -> this is index 4, so search left (next number has to be at least one more than 5, but index only increases at 1)
    //  -> 2 -> this is index 2, so it's a match
    //
    // O(log N) running time
    // O(1) space
    
    public static int find(int[] A) {
        if(A == null || A.length == 0) {
            return -1;
        }
        return find(A, 0, A.length - 1);
    }
    
    private static int find(int[] A, int start, int end) {
        if(Math.abs(start - end) <= 1) {
            return -1;
        }
        int index = (start + end)/2;
        if(A[index] == index) {
            return index;
        } else if(A[index] > index) {
            return find(A, start, index);
        } else {
            return find(A, index, end);
        }
    }
    
    // if non-distinct:
    //
    // may have something like this:
    //
    // 1 2 3 4 5 6 7 8 8 10 11 12 13
    //
    // if we go to 7, earlier we would go left but now we would be wrong in doing that.
    //
    // we must go both sides, since it's possible for it to be on either side.
    //
    // there is no way to rule out anything. imagine this:
    //
    // 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9
    //
    // depending on the size of the array, going left or right is unpredictable. we must go both ways.
    //
    // this is still O(log N) time and O(1) space
    public static int find2(int[] A) {
        if(A == null || A.length == 0) {
            return -1;
        }
        return find2(A, 0, A.length - 1);
    }
    
    private static int find2(int[] A, int start, int end) {
        if(Math.abs(start - end) <= 1) {
            return -1;
        }
        int index = (start + end)/2;
        if(A[index] == index) {
            return index;
        }
        if(find2(A, start, index) != -1) {
            return find2(A, start, index);
        } else {
            return find2(A, index, end);
        }
    }
    
    public static void main(String[] args) {
        int[] A = {-1, 0, 2, 4, 5, 8, 9, 11, 13};
        int[] B = {1, 2, 3, 4, 5, 6, 7, 8, 8, 10, 11, 12, 13};
        System.out.println(find(A));
        System.out.println(find2(B));
    }

}
