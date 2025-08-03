class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0, sum = 0;

        // Use right pointer to grow window
        for (int right = 0; right < n; right++) {
            sum += fruits[right][1];

            // Move left pointer to ensure [left, right] window can be harvested within k steps
            while (left <= right && minSteps(fruits[left][0], fruits[right][0], startPos) > k) {
                sum -= fruits[left][1];
                left++;
            }
            maxFruits = Math.max(maxFruits, sum);
        }
        return maxFruits;
    }

    // Calculate min steps needed to cover [left, right] with startPos
    private int minSteps(int leftPos, int rightPos, int startPos) {
        // Go to left, then to right
        int leftFirst = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        // Go to right, then to left
        int rightFirst = Math.abs(startPos - rightPos) + (rightPos - leftPos);
        return Math.min(leftFirst, rightFirst);
    }
    
}