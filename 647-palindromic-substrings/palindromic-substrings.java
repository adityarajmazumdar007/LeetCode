class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] t = new boolean[n][n];

        int count = 0;

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    t[i][i] = true; 
                } else if (i + 1 == j) {
                    t[i][j] = (s.charAt(i) == s.charAt(j)); // Strings of 2 Length
                } else {
                    t[i][j] = (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1]);
                }

                if (t[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}