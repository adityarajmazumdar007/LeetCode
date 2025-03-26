import java.util.*;

class Solution {
    private double[][] dp;
    private int[][] serves = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};

    private double solve(double A, double B) {
        if (A <= 0 && B <= 0) {
            return 0.5;
        }
        if (A <= 0) {
            return 1.0;
        }
        if (B <= 0) {
            return 0.0;
        }

        if (dp[(int) A][(int) B] != -1.0) {
            return dp[(int) A][(int) B];
        }

        double probability = 0.0;

        for (int[] p : serves) {
            double A_serve = p[0];
            double B_serve = p[1];
            probability += 0.25 * solve(A - A_serve, B - B_serve);
        }

        return dp[(int) A][(int) B] = probability;
    }

    public double soupServings(int n) {
        if (n >= 5000) {
            return 1.0;
        }

        int size = n + 1;
        dp = new double[size][size];

        for (double[] row : dp) {
            Arrays.fill(row, -1.0);
        }

        return solve(n, n);
    }
}
