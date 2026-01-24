class Solution {
public:
    int minPairSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int i=0;
        int j=nums.size()-1;
        int ans=INT_MIN;
        while(i<j){
            int x=nums[i]+nums[j];
            ans=max(ans,x);
            i++;
            j--;
        }
   return ans; }
};