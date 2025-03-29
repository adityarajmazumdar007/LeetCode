class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        HashMap <Integer, Integer> currentSeenMaxLength = new HashMap<>();

        int maxLength = 1;

        for (int num : arr) {

            int prevNum = num - difference;

            int prevLength = currentSeenMaxLength.getOrDefault (prevNum , 0);

            int currentLength = prevLength + 1;

            maxLength = Math.max(maxLength, currentLength);

            currentSeenMaxLength.put(num, currentLength);
        }

        return maxLength;
    }
}