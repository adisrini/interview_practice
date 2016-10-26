package ch9.sorting;

public class QuickSelect {
    
    public static int quickselect(int[] array, int k) {
        return quickselect(array, 0, array.length - 1, k);
    }
    
    private static int quickselect(int[] array, int start, int end, int k) {
        if(start == end) {
            return array[start];
        }
        
        int pivotIndex = (start + end)/2;
        pivotIndex = partition(array, start, end, pivotIndex);
        if(k == pivotIndex) {
            return array[k];
        } else if(k > pivotIndex) {
            return quickselect(array, pivotIndex + 1, end, k);
        } else {
            return quickselect(array, start, pivotIndex - 1, k);
        }
    }
    
    private static int partition(int[] array, int start, int end, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, end);
        int storeIndex = start;
        for(int i = start; i < end; i++) {
            if(array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, end, storeIndex);
        return storeIndex;
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] array = {4, 1, 2, 8, 6, 9, 3};
        System.out.println(quickselect(array, 10));
    }

}
