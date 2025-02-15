class Solution {
    public void helper(int index, int nums[], int len,
            List<List<Integer>>  ans, List<Integer>  temp ) {
            if(index >= len) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            temp.add(nums[index]);
            helper(index+1, nums, len, ans, temp);
            temp.remove(temp.size()-1);
            helper(index+1, nums, len, ans, temp);
                        }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer>  temp = new ArrayList<>();
        helper(0, nums, nums.length, ans, temp);
        return ans;
    }
}