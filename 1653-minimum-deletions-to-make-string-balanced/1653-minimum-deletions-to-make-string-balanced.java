class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int countA = 0;  // Total count of 'a' in the string
        int countB = 0;  // Number of 'b's encountered so far
        int minDeletions = Integer.MAX_VALUE;

        // First pass: Count total number of 'a'
        for (char c : s.toCharArray()) {
            if (c == 'a') countA++;
        }

        // Second pass: Calculate min deletions dynamically
        for (char c : s.toCharArray()) {
            minDeletions = Math.min(minDeletions, countB + countA);

            // Update counters based on current character
            if (c == 'b') countB++; // More 'b's before
            else countA--;          // Fewer 'a's remaining
        }

        // Edge case: If the entire string is already valid
        return Math.min(minDeletions, countB);
    }
}

