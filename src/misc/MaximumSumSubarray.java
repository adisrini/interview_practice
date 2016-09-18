package misc;

import java.util.Arrays;

public class MaximumSumSubarray {
    
    public static int naive(int[] array) {
        
        int max = 0;
        
        for(int start = 0; start < array.length - 1; start++) {
            for(int end = 1; end < array.length; end++) {
                int sum = 0;
                for(int i = start; i <= end; i++) {
                    sum += array[i];
                }
                if(sum > max) {
                    max = sum;
                }
            }
        }
        
        return max;
    }
    
    public static int dynamic(int[] array) {
        int[] maxes = new int[array.length];
        
        maxes[0] = Math.max(array[0], 0);
        
        for(int i = 1; i < array.length; i++) {
            maxes[i] = Math.max(maxes[i-1] + array[i], 0);
        }
        
        int max = 0;
        
        for(int i = 0; i < maxes.length; i++) {
            if(max < maxes[i]) {
                max = maxes[i];
            }
        }
        
        return max;
    }
    
    public static int smart(int[] array) {
        int current_max_so_far = 0;
        int best_max_so_far = 0;
        
        for(int i = 0; i < array.length; i++) {
            current_max_so_far = Math.max(current_max_so_far + array[i], 0);
            best_max_so_far = Math.max(current_max_so_far, best_max_so_far);
        }
        
        return best_max_so_far;
    }

    public static void main(String[] args) {
        int[] array = {-3, -6, 10, 3, -1, 10};
        System.out.println(naive(array));
        System.out.println(dynamic(array));
        System.out.println(smart(array));
    }
    
}
