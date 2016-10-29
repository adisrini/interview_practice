package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhysicsExperiment {
    
    static class Range implements Comparable<Range> {
        
        int student;
        int start;
        int end;
        
        Range(int student, int start, int end) {
            this.student = student;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Range o) {
            return Integer.compare(start, o.start);
        }
        
        @Override
        public String toString() {
            return String.format("%d:[%d, %d]", student, start, end);
        }
    }
    
    public static int schedule(int n, List<List<Integer>> students) {
        int[] a = new int[n];
                
        List<Range> ranges = new ArrayList<>();
        
        for(int i = 0; i < students.size(); i++) {
            List<Integer> student = students.get(i);
            int start = student.get(0);
            int end = student.get(0);
            for(int j = 0; j < student.size(); j++) {
                int curr = student.get(j);
                if(curr - end <= 1) {
                    end = curr;
                } else {
                    Range range = new Range(i + 1, start, end);
                    ranges.add(range);
                    start = end = curr;
                }
            }
            Range range = new Range(i + 1, start, end);
            ranges.add(range);
        }
                
        int currentStep = 1;
        
        Range furthestRange = null;
        int rangeDist = Integer.MIN_VALUE;

        while(currentStep <= n) {
            for(Range range : ranges) {
                if(inRange(range, currentStep) && (range.end > rangeDist)) {
                    furthestRange = range;
                    rangeDist = range.end;
                }
            }
            for(int i = currentStep - 1; i < furthestRange.end; i++) {
                a[i] = furthestRange.student;
            }
            currentStep = rangeDist + 1;
        }
        
        System.out.println(Arrays.toString(a));
        
        int switches = 0;
        for(int i = 1; i < a.length; i++) {
            if(a[i] != a[i - 1]) {
                switches++;
            }
        }
        
        return switches;
    }
    
    private static boolean inRange(Range range, int step) {
        return step >= range.start && step <= range.end;
    }
    
    public static void main(String[] args) {
        
        int n = 5;
        List<List<Integer>> students = new ArrayList<>();
        List<Integer> student1 = new ArrayList<>();
        student1.addAll(Arrays.asList(1, 2, 5));
        List<Integer> student2 = new ArrayList<>();
        student2.addAll(Arrays.asList(1, 3, 5));
        List<Integer> student3 = new ArrayList<>();
        student3.addAll(Arrays.asList(2, 3, 4));
        students.addAll(Arrays.asList(student1, student2, student3));
        
        System.out.println(schedule(n, students));
    }

}
