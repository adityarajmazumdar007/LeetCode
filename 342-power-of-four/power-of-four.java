class Solution {
    public boolean isPowerOfFour(int n) {
         if (n <= 0) return false;
        boolean isPowerOfTwo = (n & (n - 1)) == 0; // single 1-bit
        // For 4^k: 4^k % 3 == 1 for all k >= 0
        return isPowerOfTwo && (n % 3 == 1);
    }
}