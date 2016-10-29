package misc;

public class MaximumSumSubarray {
    
    public static int dynamic(int[] A) {
        int[] memo = new int[A.length + 1];
        memo[0] = 0;
        for(int i = 1; i < memo.length; i++) {
            memo[i] = Math.max(memo[i - 1] + A[i - 1], 0);
        }
        int max = 0;
        for(int i = 0; i < memo.length; i++) {
            max = Math.max(memo[i], max);
        }
        return max;
    }
    
    public static int smart(int[] A) {
        int current_max_so_far = 0;
        int max_so_far = 0;
        for(int i = 0; i < A.length; i++) {
            if(current_max_so_far + A[i] > 0) {
                current_max_so_far = current_max_so_far + A[i];
            } else {
                current_max_so_far = 0;
            }
            max_so_far = Math.max(current_max_so_far, max_so_far);
        }
        return max_so_far;
    }
    
    public static void main(String[] args) {
        int[] array = {-1, 4, -2, 0, 6, 1};
//        System.out.println(naive(array));
        System.out.println(dynamic(array));
        System.out.println(smart(array));
    }
    
}
