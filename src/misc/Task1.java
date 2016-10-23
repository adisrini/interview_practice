package misc;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    
    public String solution(String S, int K) {
     // write your code in Java SE 8
        List<Character> characters = capitalAlphanumericCharactersAsList(S);
        
        StringBuilder builder = new StringBuilder();
        
        int count = 0;
        int index = characters.size() - 1;
        while(index >= 0) {
            if(count == K) {
                builder.append("-");
                count = 0;
            } else {
                builder.append(characters.get(index));
                count++;
                index--;
            }
        }
        
        double dashes = Math.ceil((double) characters.size() / (double) K) - 1;
        
        int length = (int) (dashes + characters.size());
        
        System.out.println(builder.length() == length);
        
        return builder.reverse().toString();
    }
    
    private List<Character> capitalAlphanumericCharactersAsList(String S) {
        List<Character> characters = new ArrayList<>();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c != '-') {
                characters.add(Character.toUpperCase(c));
            }
        }
        return characters;
    }
    
    public static void main(String[] args) {
        Task1 t1 = new Task1();
        System.out.println(t1.solution("2-sdfks-a-4A0alsd--sdfs-d23fj-sdfakjsr7-4k", 100));
    }

}
