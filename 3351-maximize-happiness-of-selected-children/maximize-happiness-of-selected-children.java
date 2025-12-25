class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness); // ascending
        long sum = 0;

        // take from the end (largest first)
        int n = happiness.length;
        for (int i = 0; i < k; i++) {
            int val = happiness[n - 1 - i]; // i-th largest
            long gain = val - (long) i;
            if (gain <= 0) break;           // further gains will be <= 0 as values are non-increasing
            sum += gain;
        }
        return sum;
    }
}