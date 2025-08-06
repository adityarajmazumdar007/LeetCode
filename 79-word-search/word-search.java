public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // k is the index of the current character in the word
    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        // Base case: all characters matched
        if (k == word.length()) return true;
        // Check boundaries and current character match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || board[i][j] != word.charAt(k)) {
            return false;
        }
        // Mark cell as visited (change the char temporarily)
        char temp = board[i][j];
        board[i][j] = '#';
        // Explore all 4 directions
        boolean found = dfs(board, word, i+1, j, k+1) ||
                        dfs(board, word, i-1, j, k+1) ||
                        dfs(board, word, i, j+1, k+1) ||
                        dfs(board, word, i, j-1, k+1);
        // Unmark cell
        board[i][j] = temp;
        return found;
    }
}
