package misc;

public class ReverseWords {
    
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        reverseRange(array, 0, array.length);
        int start = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == ' ') {
                reverseRange(array, start, i);
                start = i + 1;
            }
        }
        reverseRange(array, start, array.length);
        return new String(array);
    }
    
    private void reverseRange(char[] s, int start, int end) {
        int last = (end + start);
        for(int i = start; i < last/2; i++) {
            char temp = s[i];
            s[i] = s[last - i - 1];
            s[last - i - 1] = temp;
        }
    }
    
    public static void main(String[] args) {
        ReverseWords rv = new ReverseWords();
        
        System.out.println(rv.reverseWords("the sky is blue"));
    }

}
