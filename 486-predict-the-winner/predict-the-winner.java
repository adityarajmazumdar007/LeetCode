import java.util.*;

class Solution {
    private int[][][] dp;
    private int n;

    private int solveForAlice(int[] nums, int person, int l, int r) {
        if (l > r) return 0; // Base case: No more elements left
        
        if (dp[person][l][r] != -1) return dp[person][l][r];

        if (person == 1) { // Alice's turn (maximize score)
            int takeLeft = nums[l] + solveForAlice(nums, 0, l + 1, r);
            int takeRight = nums[r] + solveForAlice(nums, 0, l, r - 1);
            return dp[person][l][r] = Math.max(takeLeft, takeRight);
        } else { // Bob's turn (minimize Alice's advantage)
            int takeLeft = solveForAlice(nums, 1, l + 1, r);
            int takeRight = solveForAlice(nums, 1, l, r - 1);
            return dp[person][l][r] = Math.min(takeLeft, takeRight);
        }
    }

    public boolean predictTheWinner(int[] nums) {
        n = nums.length;
        dp = new int[2][n][n];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        int total = Arrays.stream(nums).sum();
        int aliceScore = solveForAlice(nums, 1, 0, n - 1);
        int bobScore = total - aliceScore;

        return aliceScore >= bobScore;
    }
}
