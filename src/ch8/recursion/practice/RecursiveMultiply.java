package ch8.recursion.practice;

public class RecursiveMultiply {
    
    // multiplication is essentially repeated addition, so 3x4 is 3 + 3 + 3 + 3
    // 
    // we can call this recursively to simulate multiplication using addition
    //
    
    public static int mult(int x, int y) {
        if(x == 0 || y == 0) {
            return 0;
        }
        return (x < y) ? mult(x, y, 0, 0) : mult(y, x, 0, 0);
    }
    
    private static int mult(int x, int y, int count, int running) {
        if(x == count) {
            return running;
        } else {
            return mult(x, y, count + 1, running + y);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(mult(10, 3));
    }

}
