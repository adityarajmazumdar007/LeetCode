class Solution {
    public void setZeroes(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;
        int x[] = new int[n];
        int y[] = new int [m];
        Arrays.fill(x,-1);
        Arrays.fill(y,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    y[j]=0;
                    x[i]=0;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(y[j]==0 || x[i]==0)matrix[i][j]=0;
            }
        }
      return;  
    }
}