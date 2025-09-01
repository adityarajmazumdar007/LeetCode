class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     int n = arr.length;
        int left = 0, right = n - k; // search over possible window starts

        while (left < right) {
            int mid = left + (right - left) / 2;
            // Compare distances of the two candidate edges:
            // window [mid .. mid+k-1] vs window [mid+1 .. mid+k]
            int leftGap = x - arr[mid];
            int rightGap = arr[mid + k] - x;

            // If left gap is strictly larger, right window is better.
            // Else (including tie), prefer the left window (smaller values).
            if (leftGap > rightGap) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left is the best starting index; collect k elements (already sorted)
        List<Integer> ans = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) ans.add(arr[i]);
        return ans;
    }
}