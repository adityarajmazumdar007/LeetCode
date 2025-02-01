class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        int s=1;
        int e=1e9,ans=1e9;
        while(s<=e){
            int mid=(s+e)/2;
            int counter=0;
            for(int i=0;i<nums.size();i++){
                if(nums[i]<=mid){
                    counter++;
                    i++;
                }
                
            }
            if(counter>=k){
                ans=min(ans,mid);
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
   return ans; }
};