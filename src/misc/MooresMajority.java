package misc;

public class MooresMajority {
    
    public static int majority(int[] A) {
        int counter = 0;
        Integer candidate = null;
        
        for(Integer e : A) {
            if(counter == 0) {
                candidate = e;
                counter = 1;
            } else {
                if(!candidate.equals(e)) {
                    counter--;
                } else {
                    counter++;
                }
            }
        }
        
        return candidate;
    }
    
    public static void main(String[] args) {
        System.out.println(majority(new int[]{1, 1, 1, 2, 3, 2, 1, 3, 3, 2, 1, 1, 1}));
    }

}
