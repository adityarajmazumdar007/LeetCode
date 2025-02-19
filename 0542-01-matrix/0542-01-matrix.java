class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m = mat[0].length;
        int vis[][] = new int [n][m];
        int dist[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for ( int i = 0; i < n; i++){
            for ( int j = 0; j <m ; j++) {
                if ( mat[i][j] == 0) {
                    q.offer (new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int delR[] = {-1,0,1,0};
        int delC[] = {0,1,0,-1};
        while(q.size()!= 0){
            int r=q.peek().row;
            int c=q.peek().col;
            int dis=q.peek().dist;
            q.poll();
            dist[r][c] =dis;
            for(int i=0;i<4;i++){
            int nrow= r+delR[i];
            int ncol = c + delC[i];
            if(nrow >=0 && nrow< n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]==1){
                vis[nrow][ncol]=1;
                q.offer(new Pair(nrow,ncol,dis+1));
            }
            }
        }
        return dist;
    }
}