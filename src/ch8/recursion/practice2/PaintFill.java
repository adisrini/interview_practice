package ch8.recursion.practice2;

/**
 * Paint Fill: Implement the "paint fill" function that one might see on many
 * image editing programs. That is, given a screen (represented by a
 * two-dimensional array of colors), a point, and a new color, fill in the
 * surrounding area until the color changes from the original color.
 * 
 * @author Aditya Srinivasan
 *
 */
public class PaintFill {
    
    public static void fill(int[][] screen, int r, int c, int newColor) {
        fill(screen, r, c, newColor, screen[r][c]);
    }
    
    public static void fill(int[][] screen, int r, int c, int newColor, int originalColor) {
        if(r < 0 || r >= screen.length || c < 0 || c >= screen[0].length || screen[r][c] != originalColor) {
            return;
        }
        screen[r][c] = newColor;
        fill(screen, r + 1, c, newColor, originalColor);
        fill(screen, r, c - 1, newColor, originalColor);
        fill(screen, r, c + 1, newColor, originalColor);
        fill(screen, r - 1, c, newColor, originalColor);
    }
    
    public static void main(String[] args) {
        int[][] screen = {{0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                          {0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
                          {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                          {0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                          {0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                          {0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                          {0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                          {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                          {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        for(int i = 0; i < screen.length; i++) {
            for(int j = 0; j < screen[i].length; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
        fill(screen, 3, 3, 2);
        System.out.println("\n FILLED SCREEN");
        for(int i = 0; i < screen.length; i++) {
            for(int j = 0; j < screen[i].length; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }

}
