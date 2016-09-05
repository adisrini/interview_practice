package ch4.treesandgraphs.practice;

public class Permutation {
    
    public static void permute(String string) {
        boolean[] visited = new boolean[string.length()];
        StringBuffer buffer = new StringBuffer(string.length());
        permuteHelper(string, visited, buffer, 0);
    }
    
    public static void permuteHelper(String string, boolean[] visited, StringBuffer buffer, int position) {
        if(position == string.length()) {
            System.out.println(buffer.toString());
            return;
        }
        for(int i = 0; i < string.length(); i++) {
            if(!visited[i]) {
                buffer.append(string.charAt(i));
                visited[i] = true;
                permuteHelper(string, visited, buffer, position + 1);
                buffer.deleteCharAt(buffer.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        permute("abc");
    }

}
