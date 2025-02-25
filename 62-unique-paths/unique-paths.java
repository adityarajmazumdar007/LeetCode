class Solution {
     private static int solve(int row, int coloumn,int storageSystem [][]){
        if( row==0 && coloumn ==0)return 1;
        if(row< 0 || coloumn < 0)return 0;
        if(storageSystem[row][coloumn]!=-1)return storageSystem[row][coloumn];
        
        int upwards = solve(row-1,coloumn,storageSystem);
        int leftwards = solve(row,coloumn-1,storageSystem);
        return storageSystem[row][coloumn]=upwards+leftwards;
        
    }
    
    public int uniquePaths(int m, int n) {
        int storageSystem [][] = new int[m][n];
        for (int i = 0; i < m; i++) {
        Arrays.fill(storageSystem[i], -1);
        }
        return solve(m-1,n-1,storageSystem);
    }
}