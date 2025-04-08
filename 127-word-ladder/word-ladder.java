class Solution {
    public List < String > findAdj (String node, HashSet < String > visited) {
         List < String > adj = new ArrayList <> ();
        for (int i = 0; i < node.length(); i++) {
            for ( char ch = 'a' ; ch <='z' ; ch++) {
                //if ( ch == node.charAt(i)) continue;
                String newWord = node.substring(0,i) + ch + node.substring(i+1,node.length());
                if (visited.contains(newWord) ) adj.add(newWord);
            }
        }
        return adj;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet < String > visited = new HashSet < String > (wordList);
        if ( !visited.contains(endWord) ) return 0;
        Queue < String > q = new LinkedList<>();
        q.offer(beginWord);
        if ( visited.contains(beginWord) ) visited.remove(beginWord);
        int level = 0;
        while ( q.size() !=0 ) {
            int currLevelSize = q.size();
            for ( int i = 0; i < currLevelSize; i++ ) {
                String  node = q.poll ();
                if (node.equals(endWord)) { 
                return level + 1; }
                List < String > neighbours = findAdj ( node, visited) ;
                for ( String neighbour : neighbours ) {
                    if ( visited.contains(neighbour)) {
                        q.offer ( neighbour );
                        visited.remove( neighbour );
                    }
                }
            }
            level++;
        }
        return 0;
    }
}