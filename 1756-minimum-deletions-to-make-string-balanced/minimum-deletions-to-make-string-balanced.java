class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] suffixA = new int[n + 1]; // Stores count of 'a's to the right of index i
        int[] prefixB = new int[n + 1]; // Stores count of 'b's to the left of index i

        // Compute suffixA
        for (int i = n - 1; i >= 0; i--) {
            suffixA[i] = suffixA[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }

        // Compute prefixB
        for (int i = 1; i <=n; i++) {
            prefixB[i] = prefixB[i - 1] + (s.charAt(i - 1) == 'b' ? 1 : 0);
        }

        int result = Integer.MAX_VALUE;
        
        // Compute the minimum deletions
        for (int i = 0; i <= n; i++) {
            result = Math.min(result, prefixB[i] + suffixA[i]);
        }
        
        return result;
    }
}
