
public class Solution {
   
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // Handle edge case where arrays are empty
        if (fruits == null || baskets == null || fruits.length == 0 || baskets.length == 0)
            return fruits == null ? 0 : fruits.length;

        int n = fruits.length;
        boolean[] used = new boolean[n]; // Track which baskets are used
        int unplacedCount = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            // Try to place fruit[i] in the leftmost unused basket
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true; // Mark basket as used
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplacedCount++; // Could not place this fruit type
            }
        }
        return unplacedCount;
    }
}
