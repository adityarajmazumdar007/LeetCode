import java.util.*;

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
        String word = "";
    }

    private int rows, cols;
    private List<String> result = new ArrayList<>();
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private TrieNode getNode() {
        return new TrieNode();
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = getNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
        node.word = word;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '$' || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        char ch = board[i][j];
        node = node.children[ch - 'a'];

        if (node.isEndOfWord) {
            result.add(node.word);
            node.isEndOfWord = false;
        }

        board[i][j] = '$';
        
        for (int[] dir : directions) {
            dfs(board, i + dir[0], j + dir[1], node);
        }

        board[i][j] = ch; // Restore board
    }

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        TrieNode root = getNode();
        for (String word : words) {
            insert(root, word);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root);
                }
            }
        }
        return result;
    }
}
