import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking process
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        // Base Case: If target is 0, current path is a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(path)); // Add a copy of path
            return;
        }
        // If target becomes negative, stop exploring this path
        if (target < 0) return;

        // Explore each candidate starting from 'start' to allow repeated use
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]); // Choose candidate
            // Call recursively with updated target; same i (not i+1) since we can reuse same element
            backtrack(candidates, target - candidates[i], i, path, result);
            path.remove(path.size() - 1); // Undo choice (backtrack)
        }
    }
}
