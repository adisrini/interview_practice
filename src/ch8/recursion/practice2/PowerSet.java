package ch8.recursion.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
    
    public static <T> List<Set<T>> subset(List<T> set) {
        int n = (int) Math.pow(2,  set.size());
        
        List<Set<T>> ans = new ArrayList<>(n);
        
        for(int i = 0; i < n; i++) {
            int k = i;
            int pos = 2;
            Set<T> sub = new HashSet<>();
            while(k != 0) {
                if((k & 1) == 1) {
                    sub.add(set.get(pos));
                }
                k >>= 1;
                pos--;
            }
            ans.add(sub);
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.addAll(Arrays.asList(1, 2, 3));

        List<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList("a", "b", "c"));
        
        System.out.println(subset(ints));
        System.out.println(subset(strings));
    }

}
