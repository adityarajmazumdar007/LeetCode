import java.util.*;

class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    private int solve(int idx, int[] arr1, int[] arr2, int prev) {
        if (idx == arr1.length)
            return 0;

        String key = idx + "," + prev;
        if (memo.containsKey(key))
            return memo.get(key);

        int result1 = (int) 1e9 + 1;

        // If the current element of arr1 is greater than prev, we can keep it
        if (arr1[idx] > prev) {
            result1 = solve(idx + 1, arr1, arr2, arr1[idx]);
        }

        int result2 = (int) 1e9 + 1;
        int i = upperBound(arr2, prev);

        if (i < arr2.length) {
            result2 = 1 + solve(idx + 1, arr1, arr2, arr2[i]);
        }

        int res = Math.min(result1, result2);
        memo.put(key, res);
        return res;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2); // Sort arr2 to use binary search (upper_bound)
        memo.clear();

        int result = solve(0, arr1, arr2, Integer.MIN_VALUE);

        return result == (int) 1e9 + 1 ? -1 : result;
    }

    private int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
