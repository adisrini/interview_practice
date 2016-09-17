package ch9.sorting;

import java.util.Arrays;

public class MergeSort {
    
    public static int[] sort(int[] array) {
        if(array.length == 1) {
            return array;
        }
        int[] left = subset(array, 0, array.length / 2);
        System.out.println("LEFT: " + Arrays.toString(left));
        int[] right = subset(array, array.length / 2, array.length);
        System.out.println("RIGHT: " + Arrays.toString(right));
        int[] combined = merge(sort(left), sort(right));
        System.out.println("COMB: " + Arrays.toString(combined));
        return combined;
    }
    
    private static int[] subset(int[] array, int start, int end) {
        int[] sub = new int[end - start];
        int pos = 0;
        for(int i = start; i < end; i++) {
            sub[pos] = array[i];
            pos++;
        }
        return sub;
    }
    
    private static int[] merge(int[] left, int[] right) {
        int[] combined = new int[left.length + right.length];
        int l_index = 0;
        int r_index = 0;
        int index = 0;
        while(l_index != left.length || r_index != right.length) {
            if(l_index == left.length) {
                combined[index] = right[r_index];
                r_index++;
                index++;
                continue;
            }
            if(r_index == right.length) {
                combined[index] = left[l_index];
                l_index++;
                index++;
                continue;
            }
            if(left[l_index] < right[r_index]) {
                combined[index] = left[l_index];
                l_index++;
            } else {
                combined[index] = right[r_index];
                r_index++;
            }
            index++;
        }
        return combined;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 3, 8, 6, 2, 7};
        System.out.println(Arrays.toString(sort(array)));
    }

}
