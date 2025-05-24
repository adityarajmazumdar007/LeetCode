class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        int n = board.length;
        int m = board[0].length;
        int wordLen = word.length();

        // Directions: 0:L-R, 1:R-L, 2:T-B, 3:B-T
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                for (int i = 0; i < 4; i++) {
                    if (canPlaceInDirection(board, word, r, c, dr[i], dc[i], n, m, wordLen)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean canPlaceInDirection(char[][] board, String word, 
                                        int r, int c, int dr, int dc, 
                                        int n, int m, int wordLen) {
        // Check cell before the start of the word
        int prevR = r - dr;
        int prevC = c - dc;
        if (prevR >= 0 && prevR < n && prevC >= 0 && prevC < m) { // If in bounds
            if (board[prevR][prevC] != '#') {
                return false; // Must be blocked by '#' if not a board edge
            }
        }
        // Else (out of bounds): it's a valid boundary

        // Check cells for the word itself
        for (int k = 0; k < wordLen; k++) {
            int currR = r + k * dr;
            int currC = c + k * dc;

            if (currR < 0 || currR >= n || currC < 0 || currC >= m) {
                return false; // Word goes out of bounds
            }
            if (board[currR][currC] == '#') {
                return false; // Word hits a blocked cell
            }
            if (board[currR][currC] != ' ' && board[currR][currC] != word.charAt(k)) {
                return false; // Mismatch with existing character
            }
        }

        // Check cell after the end of the word
        int nextR = r + wordLen * dr;
        int nextC = c + wordLen * dc;
        if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) { // If in bounds
            if (board[nextR][nextC] != '#') {
                return false; // Must be blocked by '#' if not a board edge
            }
        }
        // Else (out of bounds): it's a valid boundary
        
        return true;
    }
}