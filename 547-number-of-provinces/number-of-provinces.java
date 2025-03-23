class DSU {
    public int parents[];
    public int size[];
    DSU(int nodes) {
        parents = new int[nodes];
        size = new int[nodes];
        for(int i = 0; i <nodes; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int findUltimateParent(int u) {
        if(u == parents[u]) {
            return u;
        }
        parents[u] = findUltimateParent(parents[u]);
        return parents[u];
    }

    public void unionBySize(int u, int v){
        int ultParent_U = findUltimateParent(u);
        int ultParent_V = findUltimateParent(v);
        if(ultParent_U == ultParent_V)return;
        if(size[ultParent_U] < size[ultParent_V]) {
            size[ultParent_V] += size[ultParent_U];
            parents[ultParent_U] = ultParent_V;
        }
        else {
            size[ultParent_U] += size[ultParent_V];
            parents[ultParent_V] = ultParent_U;
        }
        return;
    }
}  
class Solution { 
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    dsu.unionBySize(i, j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(dsu.parents[i] == i) count++;
        }
        
    return count;
    }
}