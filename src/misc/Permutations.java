package misc;

public class Permutations {
    
    public static void perm(Object[] A) {
        perm(A, 0);
    }
    
    private static void perm(Object[] A, int index) {
        if(index == A.length) {
            for(Object obj : A) {
                System.out.print(obj);
            }
            System.out.println();
            return;
        }
        for(int i = index; i < A.length; i++) {
            A = swap(A, i, index);
            perm(A, index + 1);
            A = swap(A, i, index);
        }
    }
    
    private static Object[] swap(Object[] A, int i, int j) {
        Object t = A[i];
        A[i] = A[j];
        A[j] = t;
        return A;
    }
    
    public static void main(String[] args) {
        Character[] string = new Character[]{'a', 'b', 'c'};
        perm(string);
    }

}
