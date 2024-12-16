class Solution {
    public boolean bfs(int node, int vis[], int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 0; 
        
        while (!q.isEmpty()) {
            int parent = q.poll();
            int parentColor = vis[parent];
            int childColor = 1 - parentColor; 
            
            for (int child : graph[parent]) {
                if (vis[child] == -1) {
                    vis[child] = childColor;
                    q.add(child);
                } else if (vis[child] == parentColor) {
                   
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int vis [] = new int[V];
        Arrays.fill(vis,-1);
        for(int i=0;i<graph.length;i++){
            if(vis[i]==-1){
                if(bfs(i,vis,graph)==false)return false;
            }
        }
        return true;
    }
}