import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Step 1: Find max score to define array size
        int maxScore = Arrays.stream(score).max().getAsInt();
        int[] rankArray = new int[maxScore + 1];

        // Step 2: Store indices in rankArray
        Arrays.fill(rankArray, -1);
        for (int i = 0; i < n; i++) {
            rankArray[score[i]] = i; // Store the index at the score position
        }

        // Step 3: Assign ranks based on highest scores
        int rank = 1;
        for (int i = maxScore; i >= 0; i--) {
            if (rankArray[i] != -1) {
                int index = rankArray[i];
                if (rank == 1) {
                    result[index] = "Gold Medal";
                } else if (rank == 2) {
                    result[index] = "Silver Medal";
                } else if (rank == 3) {
                    result[index] = "Bronze Medal";
                } else {
                    result[index] = String.valueOf(rank);
                }
                rank++;
            }
        }

        return result;
    }
}
