class WordDistance {
    private final Map<String, List<Integer>> posMap = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        if (wordsDict == null) return;
        for (int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];
            posMap.computeIfAbsent(w, k -> new ArrayList<>()).add(i);
        }
        // (Lists are naturally sorted by increasing i.)
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> a = posMap.get(word1);
        List<Integer> b = posMap.get(word2);
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
            // If either word is missing, define distance as +INF or return -1
            return -1;
        }
        int i = 0, j = 0, best = Integer.MAX_VALUE;
        while (i < a.size() && j < b.size()) {
            int ia = a.get(i), ib = b.get(j);
            best = Math.min(best, Math.abs(ia - ib));
            // Advance the pointer pointing to the smaller index to try to reduce the gap
            if (ia < ib) i++;
            else j++;
        }
        return best;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */