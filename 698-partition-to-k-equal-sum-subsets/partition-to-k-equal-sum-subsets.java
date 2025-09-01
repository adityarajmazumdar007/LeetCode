import java.util.*;
import java.util.Collections;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int el : nums) total += el;

        if (total % k != 0) return false;
        if (nums.length < k) return false;

        int subsetSum = total / k;

        Arrays.sort(nums);                                      
        reverse(nums);                                           

        if (nums[0] > subsetSum) return false;                   

        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, subsetSum);
    }

    // CHANGED: tiny helper to reverse after Arrays.sort
    private void reverse(int[] a) {                               
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {      
            int t = a[i]; a[i] = a[j]; a[j] = t;                 
        }                                                        
    }                                                             

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int subsetSum) {
        if (k == 0) return true;                                  
        if (curSum == subsetSum) {                               
            return canPartition(nums, visited, 0, k - 1, 0, subsetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            if (curSum + nums[i] > subsetSum) continue;           
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, curSum + nums[i], subsetSum)) return true;
            visited[i] = false;

           
        }
        return false;
    }
}
