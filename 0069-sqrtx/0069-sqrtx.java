class Solution {
    public int mySqrt(int x) {
        int  start =1;
        int  end= x;
         int ans=0;
        while(start<=end){
            long  mid= start+ (end-start)/2;
            long val = mid * mid;
            if(val<=x){
                ans=(int)mid;
                start=(int)mid+1;
            }
            else{
                end = (int)mid-1;
            }
        }
        return ans;
    }
}