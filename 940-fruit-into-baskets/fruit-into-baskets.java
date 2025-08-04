import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int totalFruit(int[] fruits) {
        // Map to count occurrences of each fruit type in current window
        Map<Integer, Integer> countMap = new HashMap<>();
        
        int left = 0;            // Left pointer of sliding window
        int maxFruits = 0;       // Track max fruits collected
        
        // Expand window with right pointer
        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];
            // Increment count of current fruit
            countMap.put(fruit, countMap.getOrDefault(fruit, 0) + 1);
            
            // If more than two fruit types, shrink window from left
            while (countMap.size() > 2) {
                int leftFruit = fruits[left];
                countMap.put(leftFruit, countMap.get(leftFruit) - 1);
                if (countMap.get(leftFruit) == 0) {
                    countMap.remove(leftFruit);  // Remove fruit if count is zero
                }
                left++;  // Shrink window from left
            }
            
            // Update maxFruits if current window is larger
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}
