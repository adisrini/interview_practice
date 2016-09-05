package ch8.recursion.practice;

public class Coins {
    
    private static int count = 0;
    
    public static int ways(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            ways(n, 0);
            return count;
        }
    }
    
    private static void ways(int goal, int current) {
        if (goal == current) {
            count++;
            return;
        }
        if (current > goal) {
            return;
        }
        ways(goal, current + 1);
        ways(goal, current + 5);
        ways(goal, current + 10);
        ways(goal, current + 25);
    }
    
    public static void main(String[] args) {
        System.out.println(ways(10));
    }

}
