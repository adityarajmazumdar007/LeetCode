import java.util.*;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int el : nums) total += el;

        if (total % k != 0) return false;
        if (nums.length < k) return false;

        int subsetSum = total / k;

        Arrays.sort(nums);                                        // CHANGED: sort ascending
        reverse(nums);                                            // CHANGED: make it descending for stronger pruning

        if (nums[0] > subsetSum) return false;                    // CHANGED: early reject if largest > target

        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, subsetSum);
    }

    // CHANGED: tiny helper to reverse after Arrays.sort
    private void reverse(int[] a) {                               // CHANGED
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {      // CHANGED
            int t = a[i]; a[i] = a[j]; a[j] = t;                  // CHANGED
        }                                                         // CHANGED
    }                                                             // CHANGED

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int subsetSum) {
        if (k == 1) return true;                                  // CHANGED: last bucket must succeed
        if (curSum == subsetSum) {                                // (your logic) start next bucket
            return canPartition(nums, visited, 0, k - 1, 0, subsetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            if (curSum + nums[i] > subsetSum) continue;           // CHANGED: pruning — don’t overshoot

            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, curSum + nums[i], subsetSum)) return true;
            visited[i] = false;

            // CHANGED: symmetry prunes — if we failed when the bucket was empty,
            // or we failed when we tried to close the bucket exactly,
            // no point trying more at this depth.
           // if (curSum == 0 || curSum + nums[i] == subsetSum) return false; // CHANGED
        }
        return false;
    }
}
