

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Fast lookup
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string is always breakable

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If s[0:j] is breakable and s[j:i] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Early exit for current i
                }
            }
        }
        return dp[s.length()];
    }
}
