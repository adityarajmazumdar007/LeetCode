class Solution {
    public int minimumDeletions(String word, int k) {
         Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        List<Integer> freqs = new ArrayList<>(freqMap.values());
        int ans = Integer.MAX_VALUE;
        int maxFreq = Collections.max(freqs);

        // Try all possible targets (from 1 up to maxFreq)
        for (int target = 1; target <= maxFreq; target++) {
            int deletions = 0;
            for (int count : freqs) {
                if (count < target) {
                    deletions += count; // delete all
                } else if (count > target + k) {
                    deletions += count - (target + k);
                }
                // else, count in [target, target + k], keep as is
            }
            ans = Math.min(ans, deletions);
        }
        return ans;
    }
}
