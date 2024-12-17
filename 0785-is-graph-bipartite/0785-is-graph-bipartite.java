class Solution {
    public boolean colFillBFS ( int parent, int initialCol,
                              int col [], int[][] graph) {
        col [parent] = 0;
        Queue < Integer > buffer = new LinkedList < Integer > ();
        buffer.add ( parent );
        while ( buffer.size () != 0 ) {
            int p = buffer.poll();
            int parentCol = col [p];
            int neighbourCol = 1 - col [p];
            for ( Integer neigh : graph[p] ){
                if (col [neigh] == -1 ) {
                    col [neigh] = neighbourCol;
                    buffer.offer (neigh);
                }
                else if ( col [neigh] == parentCol ) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int col [] = new int [V];
        Arrays.fill(col,-1);
        for ( int i = 0; i < V ; i++) {
            if ( col [i] == -1) {
                if ( colFillBFS(i, 0, col, graph) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}