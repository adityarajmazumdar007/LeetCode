import java.util.*;

class Solution {
    private int n;

    private int solve(int[] nums, List<Boolean> visited, int operation, Map<List<Boolean>, Integer> memo) {
        if (memo.containsKey(visited)) {
            return memo.get(visited);
        }

        int maxScore = 0;

        for (int i = 0; i < n - 1; i++) {
            if (visited.get(i)) continue;

            for (int j = i + 1; j < n; j++) {
                if (visited.get(j)) continue;

                // Create a new list for state change (to avoid mutation issues)
                List<Boolean> newVisited = new ArrayList<>(visited);
                newVisited.set(i, true);
                newVisited.set(j, true);

                int currScore = operation * gcd(nums[i], nums[j]);
                int remainingScore = solve(nums, newVisited, operation + 1, memo);
                maxScore = Math.max(maxScore, currScore + remainingScore);
            }
        }

        memo.put(visited, maxScore);
        return maxScore;
    }

    public int maxScore(int[] nums) {
        n = nums.length;
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(n, false));
        Map<List<Boolean>, Integer> memo = new HashMap<>();
        return solve(nums, visited, 1, memo);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
