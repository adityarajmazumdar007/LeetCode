import java.util.*;

public class Solution {
    // Returns the length of shortest transformation sequence
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Edge case: Empty or invalid input
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
            return 0;

        Set<String> wordSet = new HashSet<>(wordList); // O(1) lookup
        if (!wordSet.contains(endWord)) return 0; // End word must be present

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1; // Start at 1 (beginWord)

        while (!queue.isEmpty()) {
            int size = queue.size(); // Level by level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // Try changing each character
                for (int j = 0; j < word.length(); j++) {
                    char[] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (arr[j] == c) continue; // Skip same character
                        arr[j] = c;
                        String nextWord = new String(arr);
                        if (nextWord.equals(endWord)) return level + 1; // Found answer
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            queue.offer(nextWord);
                            visited.add(nextWord); // Mark as visited
                        }
                    }
                }
            }
            level++;
        }
        return 0; // No path found
    }
}
