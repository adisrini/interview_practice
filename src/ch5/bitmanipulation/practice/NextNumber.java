package ch5.bitmanipulation.practice;

/**
 * Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits
 * in their binary representation.
 * 
 * @author Aditya Srinivasan
 *
 */
public class NextNumber {
    
    // We have some positive integer and must print the next smallest and largest number that have the same number of 1 bits
    // 
    // How do we find these? Suppose we have the number 18
    //
    // 10010
    
    // What is the next biggest number in decimal? 19. This has representation 10011
    // But, this has too many 1s. What about 20? This is 10100. That works.
    // Next smallest number is 17. This is 10001. That also works.
    //
    // So, what we need to do is find the rightmost 1, and shift it left for the next biggest number, and shift it right
    // for the next smallest number.
    
    // 10011. Here is 19
    //
    // 20 is 10100. 21 is 10101. Wait, so actually we are adding 1 to the leftmost 1 to get the next biggest number.
    // 18 is 10010. 17 is 10001. 16 is 10000. 15 is 01111. 14 is 01110.
    //
    
    public static void print(int n) {
        if(n <= 0) {
            System.out.println("ERROR: Number must be positive.");
            return;
        } else {
            
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println(22 % 7);
    }

}
