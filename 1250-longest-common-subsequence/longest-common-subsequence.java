class Solution {
     public int lcsUtil( int index1,int index2,String text1, String text2,int dp[][]){
         if(index1==0 || index2==0)return 0;
         if(dp[index1][index2]!=-1)return dp[index1][index2];
         if(text1.charAt(index1-1)==text2.charAt(index2-1))return dp[index1][index2]= 1+lcsUtil(index1-1,index2-1,text1,text2,dp);
         return dp[index1][index2]= Math.max(lcsUtil(index1-1,index2,text1,text2,dp),lcsUtil(index1,index2-1,text1,text2,dp));
     }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int index1=n;
        int index2=m;
        int dp [][] = new int[n+1][m+1];
        for(int arr[] :dp)Arrays.fill(arr,-1);
        return lcsUtil(index1,index2,text1,text2,dp);
    }
}