class Solution {
      public int maxPoints(int[][] pt) {
        int n = pt.length;
        if (n == 0) return 0;                 // edge guard
        if (n <= 2) return n;

        int ans = 1;

        for (int i = 0; i < n; i++) {         // CHANGED: consider every i (not just half)
            Map<String, Integer> mp = new HashMap<>(); // CHANGED: map slope as "dy/dx" reduced
            int duplicates = 1;               // count of points equal to pt[i]
            int temp = 0;                     // best count for this i (excluding duplicates)

            for (int j = i + 1; j < n; j++) {
                int dx = pt[j][0] - pt[i][0];
                int dy = pt[j][1] - pt[i][1];

                if (dx == 0 && dy == 0) {
                    // same point as pt[i]
                    duplicates++;
                    continue;
                }

                // Reduce (dy, dx) to a canonical representation
                int g = gcd(dy, dx);         // CHANGED: exact slope via integer reduction
                dy /= g;
                dx /= g;

                // Normalize sign so each direction has a unique key
                if (dx == 0) {
                    // vertical line: normalize to (dy=1, dx=0)
                    dy = 1;
                } else if (dy == 0) {
                    // horizontal line: normalize to (dy=0, dx=1)
                    dx = 1;
                } else {
                    // make dx positive
                    if (dx < 0) { dx = -dx; dy = -dy; }
                }

                String key = dy + "/" + dx;
                mp.put(key, mp.getOrDefault(key, 0) + 1);
                temp = Math.max(temp, mp.get(key) + 0); // +0 just to mirror your style
            }

            ans = Math.max(ans, temp + duplicates); // add duplicates anchored at pt[i]
        }

        return ans;
    }

    // Euclidean GCD on integers (always positive result)
    private int gcd(int a, int b) {
        a = Math.abs(a); b = Math.abs(b);
        if (b == 0) return a == 0 ? 1 : a;    // handle (0,0) gracefully
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a == 0 ? 1 : a;
    }

}