class Solution {
    public int maximumSum(int[] nums) {
        int maxSum = -1;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sumOfDigits = 0;
            while(num !=0) {
                sumOfDigits += num%10;
                num = num/10;
            }
            if(mp.containsKey(sumOfDigits)) {
                maxSum = Math.max(maxSum, nums[i] + mp.get(sumOfDigits));
            }
            mp.put(sumOfDigits, Math.max(mp.getOrDefault(sumOfDigits,0), nums[i]));
        }
        return maxSum;
    }
}