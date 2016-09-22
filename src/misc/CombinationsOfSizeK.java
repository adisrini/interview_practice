package misc;

public class CombinationsOfSizeK {
    
    public static void permute(Object[] array, int k) {
        if(k == 0 || array.length == 0) {
            return;
        }
        permute(array, k, 0, 0, new boolean[array.length]);
    }
    
    private static void permute(Object[] array, int k, int start, int currentLength, boolean[] used) {
        if(currentLength == k) {
            for(int i = 0; i < used.length; i++) {
                if(used[i]) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if(start == array.length) {
            return;
        }
        
        used[start] = true;
        permute(array, k, start + 1, currentLength + 1, used);
        

        used[start] = false;
        permute(array, k, start + 1, currentLength, used);
    }
    
    public static void main(String[] args) {
        permute(new Character[]{'a', 'b', 'c', 'd', 'e', 'f'}, 5);
    }

}
