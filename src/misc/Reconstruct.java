package misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Reconstruct {
    
    
    public String reconstruct(String string, Set<String> dict) {
        if(dict.contains(string)) {
            return string;
        }
        return helperReconstruct(string, "", 0, 1, dict);
    }

    private String helperReconstruct(String string, String sentence, int start, int end, Set<String> dict) {
        if(end == string.length()) {
            if(dict.contains(string.substring(start, end))) {
                return sentence + string.substring(start, end);
            } else {
                return null;
            }
        }
        if(dict.contains(string.substring(start, end))) {
            String check = helperReconstruct(string, sentence + string.substring(start, end) + " ", end - 1, end, dict);
            if(check != null) {
                return check;
            } else {
                return helperReconstruct(string, sentence, start, end + 1, dict);
            }
        } else {
            return helperReconstruct(string, sentence, start, end + 1, dict);
        }
    }
    
    public static void main(String[] args) {
        Reconstruct r = new Reconstruct();
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hey", "man"));
        System.out.println(r.reconstruct("heyman", dict));
    }

}
