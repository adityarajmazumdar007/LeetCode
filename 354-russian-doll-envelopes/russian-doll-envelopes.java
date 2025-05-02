class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes by width in ascending order. 
        // If two envelopes have the same width, sort by height in descending order.
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        // Extract the heights into a separate list.
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // The 'ans' list will store the increasing subsequence of heights.
        List<Integer> ans = new ArrayList<>();

        for (int height : heights) {
            // Find the position where 'height' can be placed in 'ans' using binary search.
            int pos = binarySearch(ans, height);

            // If 'height' is greater than all elements in 'ans', append it.
            if (pos == ans.size()) {
                ans.add(height);
            } 
            // Otherwise, replace the element at the found position with 'height'.
            else {
                ans.set(pos, height);
            }
        }

        // The size of 'ans' represents the length of the longest increasing subsequence.
        return ans.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}