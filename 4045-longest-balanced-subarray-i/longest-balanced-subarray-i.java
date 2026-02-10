import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int ml = 0;
        int n = nums.length;
        //
        for (int i = 0; i < n; i++) {
            Set<Integer> eve = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    eve.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }
                if (eve.size() == odd.size()) {
                    ml = Math.max(ml, j - i + 1);
                }
            }
        }
        return ml;
    }
}
