class Solution {
    // Helper removes all occurrences of pattern A+B in one left-to-right pass
    // and appends the leftover to 'out'. Returns the points earned in this pass.
    private long removePattern(String s, char A, char B, int points, StringBuilder out) {
        long gained = 0;
        // Using StringBuilder as a stack for O(1) push/pop-at-end
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If current char completes the pattern A+B with the previous char,
            // pop the previous 'A' and score 'points' (we do NOT append 'B').
            int len = out.length();
            if (ch == B && len > 0 && out.charAt(len - 1) == A) {
                out.deleteCharAt(len - 1); // pop 'A'
                gained += points;          // add score for one removal of A+B
            } else {
                out.append(ch);            // otherwise keep the character
            }
        }
        return gained;
    }

    public int maximumGain(String s, int x, int y) {
        // Guard: empty string → no points.
        if (s == null || s.isEmpty()) return 0;

        long total = 0;

        if (x >= y) {
            // Remove "ab" first, then "ba"
            StringBuilder afterFirst = new StringBuilder();
            total += removePattern(s, 'a', 'b', x, afterFirst);

            StringBuilder afterSecond = new StringBuilder();
            total += removePattern(afterFirst.toString(), 'b', 'a', y, afterSecond);
        } else {
            // Remove "ba" first, then "ab"
            StringBuilder afterFirst = new StringBuilder();
            total += removePattern(s, 'b', 'a', y, afterFirst);

            StringBuilder afterSecond = new StringBuilder();
            total += removePattern(afterFirst.toString(), 'a', 'b', x, afterSecond);
        }

        return (int) total; // fits in int per constraints
    }
}
