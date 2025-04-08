class Solution {
    public List<String> findAdj(String node, Set<String> wordSet) {
        List<String> adj = new ArrayList<>();
        for (int i = 0; i < node.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == node.charAt(i)) continue;
                String newWord = node.substring(0, i) + ch + node.substring(i + 1);
                if (wordSet.contains(newWord)) adj.add(newWord);
            }
        }
        return adj;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (node.equals(endWord)) return level;

                for (String neighbor : findAdj(node, wordSet)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
