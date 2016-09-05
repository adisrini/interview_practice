package ch8.recursion.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsWithDups {
    
    public static List<String> perms(String string) {
        Map<Character, Integer> map = freqTable(string);
        List<String> results = new ArrayList<String>();
        perms(map, "", string.length(), results);
        return results;
    }
    
    private static void perms(Map<Character, Integer> map, String prefix, int remaining, List<String> results) {
        if(remaining == 0) {
            results.add(prefix);
            return;
        }
        for(Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                perms(map, prefix + c, remaining - 1, results);
                map.put(c,  count);
            }
        }
    }
    
    private static Map<Character, Integer> freqTable(String string) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }
    
    public static void main(String[] args) {
        System.out.println(perms("abbalone"));
    }

}
