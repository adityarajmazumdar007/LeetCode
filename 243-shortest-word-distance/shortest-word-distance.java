class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length == 0) return -1;
        if (word1 == null || word2 == null || word1.equals(word2)) return -1;

        int last1 = -1; // latest index of word1 seen so far
        int last2 = -1; // latest index of word2 seen so far
        int best = Integer.MAX_VALUE;

        // Single linear scan; update the index for whichever word we see
        for (int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];

            if (w.equals(word1)) {
                last1 = i;
                // If we have seen word2 before, tighten the gap
                if (last2 != -1) {
                    int gap = Math.abs(last1 - last2);
                    if (gap < best) best = gap;
                }
            } else if (w.equals(word2)) {
                last2 = i;
                // If we have seen word1 before, tighten the gap
                if (last1 != -1) {
                    int gap = Math.abs(last1 - last2);
                    if (gap < best) best = gap;
                }
            }
        }

        // Per problem, both words exist; best should be updated
        return (best == Integer.MAX_VALUE) ? -1 : best;
    }
}