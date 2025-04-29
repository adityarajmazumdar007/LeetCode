class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        int maxL=0;
         for(int i=0;i<nums.length;i++){
             if(st.contains(nums[i]-1))continue;
             else{
                 int count =0;
                 int search=nums[i];
                 while(st.contains(search)){
                     count++;
                     search++;
                 }
                 maxL=Math.max(maxL,count);
             }
         }
        return maxL;
    }
}