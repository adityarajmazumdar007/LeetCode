import java.util.*;

public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        
        // Count the occurrences of each number
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            if (count.get(num) == 0) continue; // already used
            
            // If there is a subsequence ending with num-1, extend it
            if (end.getOrDefault(num - 1, 0) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
                count.put(num, count.get(num) - 1);
            }
            // Try to create a new subsequence [num, num+1, num+2]
            else if (count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0) {
                count.put(num, count.get(num) - 1);
                count.put(num + 1, count.get(num + 1) - 1);
                count.put(num + 2, count.get(num + 2) - 1);
                end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);
            }
            // Can't extend or start a new sequence
            else {
                return false;
            }
        }
        return true;
    }
}
