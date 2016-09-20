package ch8.recursion.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackOfBoxes {
    
    static class Box {
        int w;
        int h;
        int d;
        
        Box(int w, int h, int d) {
            this.w = w;
            this.h = h;
            this.d = d;
        }
    }
    
    public static int height(List<Box> boxes) {
        return -1;
    }
    
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<Box>();
        boxes.addAll(Arrays.asList(new Box(1, 4, 3), new Box(4, 2, 7), new Box(3, 5, 4)));
        System.out.println(height(boxes));
    }
    
}
