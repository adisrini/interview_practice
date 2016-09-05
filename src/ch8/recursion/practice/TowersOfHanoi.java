package ch8.recursion.practice;

import java.util.Stack;

public class TowersOfHanoi {

    static class Tower {
        Stack<Integer> disks;
        int index;
        
        Tower(int index) {
            this.index = index;
            disks = new Stack<Integer>();
        }
        
        void add(int i) {
            if(!disks.isEmpty() && disks.peek() <= i) {
                throw new UnsupportedOperationException();
            } else {
                disks.push(i);
            }
        }
        
        void moveTopTo(Tower destination) {
            if(!disks.isEmpty()) {
                int top = disks.pop();
                destination.add(top);
            }
        }
        
        void moveToDestination(int n, Tower destination, Tower buffer) {
            if(n <= 0) {
                return;
            }
            moveToDestination(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveToDestination(n - 1, destination, this);
        }
        
        @Override
        public String toString() {
            return String.format("TOWER %d: %s", index, disks.toString());
        }
    
    }
    
    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[n];
        
        for(int i = 0; i < n; i++) {
            towers[i] = new Tower(i);
        }
        
        for(int x = n; x > 0; x--) {
            towers[0].add(x);
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(towers[i]);
        }
        
        towers[0].moveToDestination(n, towers[2], towers[1]);
        
        for(int i = 0; i < n; i++) {
            System.out.println(towers[i]);
        }
    }

}
