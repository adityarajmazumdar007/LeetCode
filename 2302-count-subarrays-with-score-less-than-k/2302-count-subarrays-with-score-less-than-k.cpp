class Solution {
public:
   long long countSubarrays(vector<int>& nums, long long k) {
        int i=0,j=0;
        int n=nums.size();
        long long sum=0;
        long long ans=0;
        while(j<n){
            sum+=nums[j];
            while(sum*(j-i+1)>=k){
                sum-=nums[i];
                i++;
            }
            if(sum*(j-i+1)<k) ans+=(j-i+1);
            j++;
        }
        return ans;
 }
};