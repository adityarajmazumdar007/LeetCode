class Solution {
    public int calculatenumberOfDays(int[] weights,int maxLoad){
        int days=1;
        int currentLoad=0;
        for(int i=0;i<weights.length;i++){
            if(currentLoad+weights[i]<=maxLoad){
                currentLoad+=weights[i];
            }
            else{
                days++;
                currentLoad=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int lowerRange = Integer.MIN_VALUE;
        int upperRange = 0;
        for(int i=0;i<weights.length;i++){
            lowerRange=Math.max(weights[i],lowerRange);
            upperRange+=weights[i];
        }
        while(lowerRange<=upperRange){
            int mid = (lowerRange+upperRange)/2;
            int numberOfDays = calculatenumberOfDays(weights,mid);
            if(numberOfDays<=days)upperRange=mid-1;
            else{lowerRange=mid+1;}
        }
        return lowerRange;
    }
}