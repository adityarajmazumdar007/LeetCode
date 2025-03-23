public class Solution {
    private int[] t = new int[10001];

    private int minSquares(int n) {
        if (n == 0)
            return 0;

        if (t[n] != -1)
            return t[n];

        // We can select only those perfect squares which can contribute to sum up to n
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            minCount = Math.min(minCount, 1 + minSquares(n - i * i)); // 1 is for selecting one square number
        }

        return t[n] = minCount;
    }

    public int numSquares(int n) {
        Arrays.fill(t, -1);

        return minSquares(n);
    }
}