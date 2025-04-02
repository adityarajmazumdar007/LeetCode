import java.util.*;

class Solution {
    private Set<String> wordSet;
    private int[] memo;
    private int n;
    
    private boolean solve(String s, int idx) {
        if (idx == n) {
            return true;
        }
        
        if (wordSet.contains(s.substring(idx, n))) {
            return true;
        }
        
        if (memo[idx] != -1) {
            return memo[idx] == 1;
        }
        
        for (int l = 1; l <= n - idx; l++) {
            String temp = s.substring(idx, idx + l);
            if (wordSet.contains(temp) && solve(s, idx + l)) {
                memo[idx] = 1;
                return true;
            }
        }
        
        memo[idx] = 0;
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        wordSet = new HashSet<>(wordDict);
        
        return solve(s, 0);
    }
}
