class Solution {
    int M = 1000000007;
    int[][][] t = new int[100001][2][3];

    int solve(int n, int absent, int consecutiveLate) {

        if(absent >= 2 || consecutiveLate >= 3) {
            return 0;
        }

        if(n == 0)
            return 1;
        
        if(t[n][absent][consecutiveLate] != -1) {
            return t[n][absent][consecutiveLate];
        }

        int A = solve(n-1, absent+1, 0) % M;
        int L = solve(n-1, absent, consecutiveLate+1) % M;
        int P = solve(n-1, absent, 0) % M;

        return t[n][absent][consecutiveLate] = ((A + L) % M + P) % M;
    }

    public int checkRecord(int n) {
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }
        return solve(n, 0, 0);
    }
}
