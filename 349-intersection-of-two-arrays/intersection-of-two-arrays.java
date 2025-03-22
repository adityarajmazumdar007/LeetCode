import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0; // k keeps track of unique elements in result
        int[] result = new int[Math.min(nums1.length, nums2.length)]; // Max possible size

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // Avoid duplicates by checking if result is empty or last element added is different
                if (k == 0 || result[k - 1] != nums1[i]) {
                    result[k++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Return only the filled part of the array
        return Arrays.copyOf(result, k);
    }
}
