class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
         String[] result = new String[n];

        // Step 1: Store the original indices of the scores
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(score[i], i);
        }

        // Step 2: Sort the scores in descending order
        Integer[] sortedScores = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedScores, Collections.reverseOrder());

        // Step 3: Assign ranks based on sorted positions
        for (int i = 0; i < n; i++) {
            int index = mp.get(sortedScores[i]);
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}