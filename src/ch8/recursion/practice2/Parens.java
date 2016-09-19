package ch8.recursion.practice2;

public class Parens {
    
    public void parens(int N) {
        parens(N, N, "");
    }
    
    private void parens(int left, int right, String prefix) {
        if(right == 0) {
            System.out.println(prefix);
            return;
        } else if(left == 0) {
            parens(left, right - 1, prefix + ")");
        } else if(left >= right) {
            parens(left - 1, right, prefix + "(");
        } else {
            parens(left - 1, right, prefix + "(");
            parens(left, right - 1, prefix + ")");
        }
    }
    
    public static void main(String[] args) {
        Parens p = new Parens();
        p.parens(2);
    }

}
