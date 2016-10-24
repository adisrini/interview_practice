package leetcode;

import java.util.Arrays;
import java.util.List;

public class ZigzagIterator {
    
    private int which;
    private List[] lists;
    private int[] indices;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists = new List[2];
        lists[0] = v1;
        lists[1] = v2;
        indices = new int[2];
        indices[0] = 0;
        indices[1] = 0;
        which = 0;
    }

    public int next() {
        // v1, v2
        // i1, i2
        int pos = indices[which];
        int element = (int) lists[which].get(pos);
        indices[which]++;
        int initial = which;
        which = (which + 1) % lists.length;
        while(indices[which] >= lists[which].size()) {
            if(which == initial) {
                break;
            }
            which = (which + 1) % lists.length;
        }
        return element;
    }

    public boolean hasNext() {
        return indices[0] < lists[0].size() || indices[1] < lists[1].size();
    }
    
    public static void main(String[] args) {
        ZigzagIterator zz = new ZigzagIterator(Arrays.asList(1,2), Arrays.asList(3,4,5,6));
        while(zz.hasNext()) {
            System.out.println(zz.next());
        }
    }
}
