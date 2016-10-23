package misc;

public class Task2 {
    
    static class Tree {
        int x;
        Tree left;
        Tree right;
        
        public Tree(int x) {
            this.x = x;
        }
    }
    
    private int number;
    
    public int solution(int A, int B, Tree T) {
        number = 0;
        helper(A, B, T);
        return number;
    }
    
    private boolean helper(int A, int B, Tree T) {
        if(T == null) {
            return true;
        }
        
        boolean left = helper(A, B, T.left);
        boolean right = helper(A, B, T.right);
        
        if(left && right && T.x >= A && T.x <= B) {
            number++;
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Task2 t = new Task2();
        
        Tree t25 = new Tree(25);
        Tree t19 = new Tree(19);
        Tree t12 = new Tree(12);
        Tree t4 = new Tree(4);
        Tree t22 = new Tree(22);
        Tree t23 = new Tree(23);
        Tree t37 = new Tree(37);
        Tree t29 = new Tree(29);
        Tree t30 = new Tree(30);
        
        t25.left = t19;
        t19.left = t12;
        t12.left = t4;
        t19.right = t22;
        t22.right = t23;
        t25.right = t37;
        t37.left = t29;
        t29.right = t30;
        
        System.out.println(t.solution(1, 100, t25));
    }

}
