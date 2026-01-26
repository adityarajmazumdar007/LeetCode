class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
       vector<vector<int>> ans;
        int md=INT_MAX;
        int d=0;
        sort(arr.begin(),arr.end());
        for(int i=0;i<arr.size()-1;i++){
            d=abs(arr[i+1]-arr[i]);
          if(d<md){
              ans.clear();
              
          }
            md=min(d,md);
            if(d==md){
                ans.push_back({arr[i],arr[i+1]});
            }
          
        
        }
   return ans; }
};