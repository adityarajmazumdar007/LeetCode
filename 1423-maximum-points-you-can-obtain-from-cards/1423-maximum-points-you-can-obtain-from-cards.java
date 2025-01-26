class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int leftSum=0;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        int maxSum=leftSum;
        int rightSum=0;
        int j=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[j];
            j--;
            maxSum=Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}