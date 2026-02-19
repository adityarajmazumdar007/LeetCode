import java.util.HashMap;

class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevRunLength = 0;
        int currentRunLength = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentRunLength++;
            } else {
                prevRunLength = currentRunLength;
                currentRunLength = 1;
            }
            
            if (prevRunLength >= currentRunLength) {
                count++;
            }
        }
        
        return count;
    }
}
