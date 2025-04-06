class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Create an array of pairs
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i]; // First element
            pairs[i][1] = nums2[i]; // Second element
        }

        // Sort the pairs based on the second element in descending order
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        // Min heap to keep track of k largest nums1
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long kSum = 0;

        // First pick k elements
        for (int i = 0; i < k; i++) {
            pq.offer(pairs[i][0]);
            kSum += pairs[i][0];
        }

        long result = kSum * (long)pairs[k - 1][1];

        // Iterate through the rest
        for (int i = k; i < n; i++) {
            int removed = pq.poll();
            kSum = kSum - removed + pairs[i][0];
            pq.offer(pairs[i][0]);

            result = Math.max(result, kSum * (long)pairs[i][1]);
        }

        return result;
    }
}
