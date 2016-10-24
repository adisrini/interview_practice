package leetcode;

public class MinMax {
    
    static class Result {
        int min;
        int max;
        
        Result(int min, int max) {
            this.min = min;
            this.max = max;
        }
        
        @Override
        public String toString() {
            return String.format("min: %d, max: %d", min, max);
        }
    }
    
    public static Result minmax(int[] a) {
        if(a.length == 1) {
            return new Result(a[0], a[0]);
        }
        if(a.length == 2) {
            return a[0] < a[1] ? new Result(a[0], a[1]) : new Result(a[1], a[0]);
        }
        
        int start = 0;
        int end = a.length - 1;
        
        while(start < end) {
            int mid = (start + end)/2;
            if(a[mid] < a[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return a[0] < a[a.length - 1] ? new Result(a[0], a[start]) : new Result(a[a.length - 1], a[start]);
    }
    
    public static void main(String[] args) {
        System.out.println(minmax(new int[]{0, 1, 4, 100, 9, -5}));
    }

}
