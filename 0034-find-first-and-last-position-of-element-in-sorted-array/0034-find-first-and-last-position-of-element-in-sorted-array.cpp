class Solution {
public:
   void start(vector<int>&nums,int target,int s,int e,vector<int> &ans){
       while(s<=e){
           int m=s+ (e-s)/2;
           if(nums[m]==target){ans[0]=m;e=m-1;}
           else if(nums[m]>target){e=m-1;}
           else{s=m+1;}
       }
   return ;}
    void end(vector<int>&nums,int target,int s,int e,vector<int> &ans){
         while(s<=e){
           int m=s+ (e-s)/2;
           if(nums[m]==target){ans[1]=m;s=m+1;}
           else if(nums[m]>target){e=m-1;}
           else{s=m+1;}
       }
    }
    
    
    vector<int> searchRange(vector<int>& nums, int target) {
        int s=0;
        int e=nums.size()-1;
        vector<int>ans(2,-1);
        start(nums,target,s,e,ans);
        s=0,e=nums.size()-1;
        end(nums,target,s,e,ans);
        return ans;
    }
};