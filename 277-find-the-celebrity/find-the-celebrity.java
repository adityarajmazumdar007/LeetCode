/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 0) return -1;
        if (n == 1) return 0; // single person is trivially a celebrity

        // 1) Eliminate to get a single candidate
        int cand = 0;
        for (int i = 1; i < n; i++) {
            // If cand knows i, cand cannot be celebrity; switch to i
            if (knows(cand, i)) {
                cand = i;
            }
            // else: i cannot be celebrity; keep cand
        }

        // 2) Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == cand) continue;

            // Rule #1: celebrity knows nobody
            if (knows(cand, i)) return -1;

            // Rule #2: everybody knows celebrity
            if (!knows(i, cand)) return -1;
        }

        return cand;
    }
}