package misc;

public class GCD {
    
    public int gcd(int a, int b) {
        if(a == 0 || b == 0) {
            return a + b;
        }
        return gcd(b, a % b);
    }
    
    
    public static void main(String[] args) {
        GCD g = new GCD();
        System.out.println(g.gcd(54, 48));
    }
}
