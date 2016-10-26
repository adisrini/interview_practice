package ch9.sorting;

import java.util.Arrays;

public class QuickSort {
    
    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
    
    private static void quicksort(int[] array, int low, int high) {
        if(low >= high) {
            return;
        }
        
        int i = low;
        int j = high;
        
        int mid = low + (high - low) / 2;
        int pivot = array[mid];
        
        while(i <= j) {
            while(array[i] < pivot) {
                i++;
            }
            while(array[j] > pivot) {
                j--;
            }
            
            if(i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        
        if(low < j) {
            quicksort(array, low, j);
        }
        
        if(high > i) {
            quicksort(array, i, high);
        }
    }
    
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 2, 8, 6};
        quicksort(array);
        System.out.println(Arrays.toString(array));
    }

}
