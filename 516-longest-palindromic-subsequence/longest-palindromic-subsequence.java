class Solution {
     private static int compare(String text1, String text2,int index1,int index2,int storageSystem[][]){
       if(index1 == 0 || index2 == 0 )return 0;
       if(storageSystem[index1][index2]!=-1)return storageSystem[index1][index2];
       if(text1.charAt(index1-1)==text2.charAt(index2-1))return storageSystem[index1][index2]=1+compare(text1,text2,index1-1,index2-1,storageSystem);
       return storageSystem[index1][index2]= Math.max(compare(text1,text2,index1-1,index2,storageSystem),compare(text1,text2,index1,index2-1,storageSystem));
       
   }
    public int longestPalindromeSubseq(String text1) {
        StringBuilder sb = new StringBuilder(text1);
        String text2 = sb.reverse().toString();
        int n= text1.length();
        int m = text2.length();
        int storageSystem[][]= new int[n+1][m+1];
        for(int arr[]:storageSystem){
            Arrays.fill(arr,-1);
        }
        return compare(text1,text2,n,m,storageSystem);
    }
}