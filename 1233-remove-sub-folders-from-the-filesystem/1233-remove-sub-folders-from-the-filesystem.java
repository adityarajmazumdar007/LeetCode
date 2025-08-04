import java.util.*;

public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);  // Sort folders lex order
        
        List<String> result = new ArrayList<>();
        String prev = "";
        
        for (String curr : folder) {
            // Check if curr is subfolder of prev
            if (prev.isEmpty() || !curr.startsWith(prev + "/")) {
                result.add(curr);  // Add curr as a top-level folder
                prev = curr;       // Update prev
            }
            // Else curr is a subfolder, skip it
        }
        
        return result;
    }
}
