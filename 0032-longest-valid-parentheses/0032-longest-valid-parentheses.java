class Solution {
    public int longestValidParentheses(String s) {
         if (s == null || s.isEmpty()) return 0;

        int left = 0, right = 0, ans = 0;

        // Left to Right
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else right++;

            if (left == right) ans = Math.max(ans, 2 * right);
            else if (right > left) { left = right = 0; }
        }

        // Right to Left
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else right++;

            if (left == right) ans = Math.max(ans, 2 * left);
            else if (left > right) { left = right = 0; }
        }

        return ans;
    }
}