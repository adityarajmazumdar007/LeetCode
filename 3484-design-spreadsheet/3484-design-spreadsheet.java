class Spreadsheet {
    // Grid of values: rows x 26 (columns A..Z)
    private final int[][] grid;
    private final int rows;

    /** Initializes the spreadsheet with given number of rows; columns are A..Z (26). */
    public Spreadsheet(int rows) {
        // Defensive: rows must be positive, but if zero is passed, create zero-by-26 grid.
        this.rows = Math.max(0, rows);
        this.grid = new int[this.rows][26]; // default 0s
    }

    /** Sets the given cell (like "A1", "B10") to a specific integer value. */
    public void setCell(String cell, int value) {
        int[] rc = parseCell(cell); // rc[0] = rowIdx (0-based), rc[1] = colIdx (0-based)
        if (rc == null) return;     // invalid cell gracefully ignored (not expected per problem)
        int r = rc[0], c = rc[1];
        if (inBounds(r, c)) {
            grid[r][c] = value;
        }
    }

    /** Resets the given cell to 0. */
    public void resetCell(String cell) {
        int[] rc = parseCell(cell);
        if (rc == null) return;
        int r = rc[0], c = rc[1];
        if (inBounds(r, c)) {
            grid[r][c] = 0;
        }
    }

    /**
     * Evaluates a formula of the form "=X+Y" where each token is either:
     * - a non-negative integer (e.g., "7")
     * - a cell reference (e.g., "C12")
     * Unset cells count as 0.
     */
    public int getValue(String formula) {
        if (formula == null || formula.length() == 0) return 0; // defensive
        // Remove leading '=' if present.
        String expr = formula.charAt(0) == '=' ? formula.substring(1) : formula;

        // Split into exactly two parts around '+'
        int plus = expr.indexOf('+');
        if (plus < 0) {
            // If no '+', treat the whole as single token (not expected in this problem, but safe)
            return evalToken(expr);
        }
        String t1 = expr.substring(0, plus);
        String t2 = expr.substring(plus + 1);
        return evalToken(t1) + evalToken(t2);
    }

    // ----- Helpers -----

    /** Returns the numeric value of a token: either integer or cell reference value. */
    private int evalToken(String token) {
        token = token.trim();
        if (token.isEmpty()) return 0;

        // If first char is a letter [A-Z], treat as cell reference
        char ch = token.charAt(0);
        if (ch >= 'A' && ch <= 'Z') {
            int[] rc = parseCell(token);
            if (rc == null) return 0;
            int r = rc[0], c = rc[1];
            return inBounds(r, c) ? grid[r][c] : 0;
        }

        // Otherwise parse as non-negative integer
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException nfe) {
            return 0; // defensive fallback
        }
    }

    /** Parses "A1".."Z{rows}" into {rowIdx, colIdx}, both 0-based. Returns null if invalid. */
    private int[] parseCell(String cell) {
        if (cell == null || cell.length() < 2) return null;
        char colChar = cell.charAt(0);
        if (colChar < 'A' || colChar > 'Z') return null;
        int col = colChar - 'A';

        // Remaining part must be a positive 1-indexed row integer
        String rowPart = cell.substring(1);
        int rowOneIndexed;
        try {
            rowOneIndexed = Integer.parseInt(rowPart);
        } catch (NumberFormatException nfe) {
            return null;
        }
        if (rowOneIndexed <= 0) return null;

        int row = rowOneIndexed - 1; // convert to 0-based
        return new int[]{row, col};
    }

    /** Bounds check for grid access. */
    private boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < 26;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */