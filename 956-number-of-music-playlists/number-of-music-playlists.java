import java.util.*;

class Solution {
    int N, GOAL, K;
    long[][] dp;
    final int MOD = 1_000_000_007;

    private long solve(int countSong, int countUnique) {
        if (countSong == GOAL) {
            return countUnique == N ? 1 : 0;
        }

        if (dp[countSong][countUnique] != -1) {
            return dp[countSong][countUnique];
        }

        long result = 0;

        // Option 1: Play a unique song
        if (countUnique < N) {
            result += (N - countUnique) * solve(countSong + 1, countUnique + 1);
        }

        // Option 2: Replay a song (only if more than K unique songs are already played)
        if (countUnique > K) {
            result += (countUnique - K) * solve(countSong + 1, countUnique);
        }

        return dp[countSong][countUnique] = result % MOD;
    }

    public int numMusicPlaylists(int n, int goal, int k) {
        this.N = n;
        this.GOAL = goal;
        this.K = k;
        this.dp = new long[goal + 1][n + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int) solve(0, 0);
    }
}
