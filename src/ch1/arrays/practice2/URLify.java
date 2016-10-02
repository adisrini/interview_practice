package ch1.arrays.practice2;

public class URLify {
    
    private static final char[] REPLACE = new char[]{'%', '2', '0', '1'};
    
    static char[] urlify(char[] string, int length) {
        int w = 0;
        for(int i = 0; i < length; i++) {
            int c = string[i];
            if(c == ' ') {
                w++;
            }
        }
        
        for(int i = length - 1; i >= 0; i--) {
            char c = string[i];
            if(c != ' ') {
                string[i + (REPLACE.length - 1)*w] = c;
            } else {
                w--;
                for(int j = 0; j < REPLACE.length; j++) {
                    string[i + (REPLACE.length - 1)*w + j] = REPLACE[j];
                }
            }
        }
        
        return string;
    }

    public static void main(String[] args) {
        System.out.println(new String((urlify("Adi Srinivasan   ".toCharArray(), 14))));
    }
    
}
