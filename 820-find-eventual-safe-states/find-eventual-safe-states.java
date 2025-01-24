class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List < List < Integer > > reverseAdj = new ArrayList<>();
        for ( int i = 0; i < V ; i++) {
            reverseAdj.add( new ArrayList<>());
        }
        for ( int i = 0; i < V; i++) {
            for ( int j = 0; j < graph[i].length ; j++ ) {
                reverseAdj.get(graph[i][j]).add(i);
            } 
        }
        int indegree [] = new int [V];
        for ( int i = 0 ; i < V ; i++ ) {
            for ( Integer it : reverseAdj.get(i) ) {
                    indegree[ it ]++;
            }
        }
        Queue < Integer > q = new LinkedList<> ();
            for ( int i= 0 ; i < V ; i++) {
                if ( indegree[i] == 0) {
                    q.offer (i);
                }
            }
        List <Integer> safeNodes = new ArrayList <> ();
        while ( q.size() != 0 )  {
            int safeNode = q.poll ();
            safeNodes.add ( safeNode );
            for ( int neighbours : reverseAdj.get (safeNode) ) {
                indegree[ neighbours ]--;
                if( indegree[ neighbours ] == 0 ) {
                    q.offer ( neighbours );
                }
            }
        }
        Collections.sort( safeNodes );
        return safeNodes;
    }
}