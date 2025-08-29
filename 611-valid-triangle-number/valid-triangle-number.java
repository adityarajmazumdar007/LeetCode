class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums); // ascending
        int n = nums.length;
        int count = 0;

        // Fix k as the index of the largest side c
        for (int k = n - 1; k >= 2; k--) {
            int c = nums[k];
            int i = 0, j = k - 1; // search pairs (i, j) with i < j < k

            while (i < j) {
                // For sorted nums: if nums[i] + nums[j] > nums[k],
                // then all pairs (i..j-1, j) with the same k are valid.
                if (nums[i] + nums[j] > c) {
                    count += (j - i);
                    j--; // tighten upper pointer
                } else {
                    i++; // need a larger small side
                }
            }
        }
        return count;
    }

}