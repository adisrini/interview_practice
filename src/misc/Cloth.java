package misc;

public class Cloth {
    
    static class Product {
        int a;
        int b;
        int c;
        
        Product(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static int maxProfit(Product[] products, int X, int Y) {
        int[][][] P = new int[products.length + 1][X + 1][Y + 1];
        
        for(int i = 1; i <= products.length; i++) {
            for(int x = 1; x <= X; x++) {
                for(int y = 1; y <= Y; y++) {
                    int prev = (x - products[i - 1].a < 0 || y - products[i - 1].b < 0) ? Integer.MIN_VALUE : P[i - 1][x - products[i - 1].a][y - products[i - 1].b];
                    P[i][x][y] = Math.max(prev + products[i - 1].c,
                                          P[i - 1][x][y]);
                }
            }
        }
        
        return P[products.length][X][Y];
    }
    
    public static void main(String[] args) {
        System.out.println(maxProfit(new Product[]{new Product(1, 1, 10), new Product(4, 2, 100)}, 5, 3));
    }

}
