class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return 0;
        }
        return helper(s, k, 0, s.length());
    }

    private int helper(String s, int k, int start, int end) {
        if (end - start < k) {
            return 0; 
        }

        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] > 0 && freq[s.charAt(i) - 'a'] < k) {
                int left = helper(s, k, start, i);
                int right = helper(s, k, i + 1, end);
                return Math.max(left, right);
            }
        }
        return end - start;
    }
}
