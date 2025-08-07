public class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    // Backtracking helper function
    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    // Try digits 1-9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (backtrack(board)) return true; // Solved!
                            board[row][col] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid number found, trigger backtrack
                }
            }
        }
        return true; // All cells filled
    }

    // Check if placing digit is valid
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Row check
            if (board[row][i] == c) return false;
            // Column check
            if (board[i][col] == c) return false;
            // Box check
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}
