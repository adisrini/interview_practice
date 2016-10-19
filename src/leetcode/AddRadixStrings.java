package leetcode;

public class AddRadixStrings {
    
private int radix = 2;
    
    public String addBinary(String a, String b) {
        int n = (b.length() > a.length()) ? b.length() : a.length();
        char[] result = new char[n + 1];
        
        int i1 = a.length() - 1;
        int i2 = b.length() - 1;
        int ir = n;
        int carry = 0;
        
        while(i1 >= 0 || i2 >= 0) {
            int val1 = (i1 < 0) ? 0 : a.charAt(i1) - '0';
            int val2 = (i2 < 0) ? 0 : b.charAt(i2) - '0';
            int sum = val1 + val2 + carry;
            int dig = sum % radix;
            carry = sum / radix;
            result[ir] = Character.forDigit(dig, 10);
            i1--;
            i2--;
            ir--;
        }
        
        if(carry == 1) {
            result[0] = '1';
        }
        
        int start = 0;
        while(start < result.length && (result[start] == '0' || result[start] == 0)) {
            start++;
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i = start; i < n + 1; i++) {
            builder.append(result[i]);
        }
        
        return (builder.length() == 0) ? "0" : builder.toString();
        
    }

}
