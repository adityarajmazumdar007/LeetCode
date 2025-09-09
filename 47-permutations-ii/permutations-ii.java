import java.util.*;

public class Solution {
    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>(nums.length);
            for (int x : nums) ds.add(x);
            ans.add(ds);
            return;
        }
        // CHANGED: track which values we've already used at this depth
        HashSet<Integer> seen = new HashSet<>(); // CHANGED
        for (int i = index; i < nums.length; i++) {
            if (seen.contains(nums[i])) continue; // CHANGED: skip duplicate choice at this depth
            seen.add(nums[i]);                    // CHANGED
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // Optional but helps cluster equal values so pruning triggers earlier
       // Arrays.sort(nums); 
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }
}
