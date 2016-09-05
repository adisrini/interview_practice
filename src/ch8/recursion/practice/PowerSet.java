package ch8.recursion.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a method to return all subsets of a set.
 * 
 */
public class PowerSet<T> {
    
    // imagine the set: {1, 2, 3}
    //
    // the subsets of this set are: {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}
    //
    // the order does not matter. also, there will be no duplicates in a set so we can ignore that case.
    //
    // the method should take a Set<T> and return a List<Set<T>>
    //
    // subsets of {a, b, c, d} = {},
    //                           {a}, {b}, {c}, {d},
    //                           {a, b}, {a, c}, {a, d}, {b, c}, {b, d}, {c, d},
    //                           {a, b, c}, {a, b, d}, {a, c, d}, {b, c, d},
    //                           {a, b, c, d}
    // -> subsets of {a, b, c} = {},
    //                           {a}, {b}, {c},
    //                           {a, b}, {a, c}, {b, c},
    //                           {a, b, c}                              -> just add d to each of these
    // -> subsets of {a, b} =    {},
    //                           {a}, {b},
    //                           {a, b}                                 -> just add c to each of these
    // -> subsets of {a}    =    {},
    //                           {a}                                    -> just add b to each of these
    //
    // so, break it down until you have a single element, find all permutations. then introduce another element and add b to existing
    // elements as new elements
    //
    
    public List<List<T>> power(List<T> set) {
        List<List<T>> subsets = new ArrayList<List<T>>();
        int size = 1 << set.size();
        for(int i = 0; i < size; i++) {
            List<T> subset = convertIndexToSubset(i, set);
            subsets.add(subset);
        }
        return subsets;
    }
    
    private List<T> convertIndexToSubset(int i, List<T> set) {
        List<T> subset = new ArrayList<T>();
        int index = 0;
        for(int k = i; k > 0; k >>= 1) {
            if((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
    
    public static void main(String[] args) {
        PowerSet<Integer> ps = new PowerSet<Integer>();
        List<Integer> set = new ArrayList<Integer>();
        set.addAll(Arrays.asList(1, 2, 3));
        List<List<Integer>> subsets = ps.power(set);
        System.out.println(subsets);
    }

}
