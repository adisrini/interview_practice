package ch5.bitmanipulation.practice;

/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR:'
 */
public class BinaryToString {

    public static String toBinary(double x) {
        if(x >= 1 || x <= 0) {
            return "ERROR";
        }
        int iter = 0;
        StringBuilder result = new StringBuilder("0.");
        double temp = x;
        while(iter <= 32) {
            temp *= 2;                              // temp is in form x.y
            char digit = (temp >= 1) ? '1' : '0';   // digit is x
            temp %= 1;                              // temp is y
            result.append(digit);
            if(temp == 0) {
                break;
            }
            iter++;
        }
        if(iter > 32) {
            return "ERROR";
        }
        return result.toString();
    }
    
    // let's try this with the number 0.25
    //
    // iter = 0, result = "0.", temp = 0.25
    // while loop -> temp = 0.5, digit = '0', temp = 0.5, result = "0.0", iter = 1
    //            -> temp = 1.0, digit = '1', temp = 0.0, result = "0.01", BREAK
    // returns "0.01", as desired
    //
    // what about something that can't be expressed as a finite binary representation?
    //
    // let's try with number 0.1
    //
    // iter = 0, result = "0.", temp = 0.1 (initialization)
    // while loop -> temp = 0.2, digit = '0', temp = 0.2, result = "0.0", iter = 1
    //            -> temp = 0.4, digit = '0', temp = 0.4, result = "0.00", iter = 2
    //            -> temp = 0.8, digit = '0', temp = 0.8, result = "0.000", iter = 3
    //            -> temp = 1.6, digit = '1', temp = 0.6, result = "0.0001", iter = 4
    //            -> temp = 1.2, digit = '1', temp = 0.2, result = "0.00011", iter = 5
    //            -> repeats entire cycle again, adding "00011" each time
    //            -> will eventually break once we have iterated 32 times

    public static void main(String[] args) {
        System.out.println(toBinary(0.5));
        System.out.println(toBinary(0.25));
        System.out.println(toBinary(0.125));
        System.out.println(toBinary(0.375));
        System.out.println(toBinary(0.75));
        System.out.println(toBinary(0.8125));
        System.out.println(toBinary(0.1));
        System.out.println(toBinary(0.3));
    }
    
}
