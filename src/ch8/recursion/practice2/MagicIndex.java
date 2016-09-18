package ch8.recursion.practice2;

public class MagicIndex {
    
    public static int magic(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == i) {
                return i;
            }
        }
        return -1;
    }
    
    public static int magic2(int[] array) {
        return magic(array, 0, array.length - 1);
    }
    
    public static int magic(int[] array, int start, int end) {
        if(Math.abs(start - end) < 1) {
            return -1;
        }
        int mid = (start + end)/2;
        if(mid == array[mid]) {
            return mid;
        } else if(mid > array[mid]) {
            return magic(array, mid + 1, end);
        } else {
            return magic(array, start, mid - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] array = {-5, -3, -1, 2, 3, 6, 8};
        System.out.println(magic(array));
        System.out.println(magic2(array));
    }

}
