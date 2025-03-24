class tuple { 
    int first, second, third; 
    tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n= maze.length;
        int m= maze[0].length;
       if(maze[entrance[0]][entrance[1]]=='+')return -1;
        int[][] dist = new int[n][m]; 
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = 0;
            }
        }
        
         Queue<tuple> q = new LinkedList<>();  
        dist[entrance[0]][entrance[1]] = 1; 
        q.add(new tuple(0, entrance[0], entrance[1])); 
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
         while(!q.isEmpty()) {
            tuple it = q.peek(); 
            q.remove(); 
            int dis = it.first; 
            int r = it.second; 
            int c = it.third; 

            for(int i = 0;i<4;i++) {
                int newr = r + dr[i]; 
                int newc = c + dc[i]; 
                if(newr >= 0 && newr < n && newc >= 0 && newc < m 
                && maze[newr][newc] == '.' && dist[newr][newc] == 0) {
                    dist[newr][newc] = 1;
                    if(newr == 0 || newr == n-1  ||
                       newc == 0 || newc== m-1) return dis + 1; 
                    q.add(new tuple(1+dis, newr, newc)); 
                }
            }
        }
        
    return -1; 
    }
}