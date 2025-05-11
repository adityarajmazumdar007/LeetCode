class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
       if(arr.size()<3)return false;
        int i=0;
        while(i<arr.size()-2){
            if(arr[i]%2 &&arr[i+1]%2 &&arr[i+2]%2 )return true;
            i++;
        }
    return false;}
};