import java.util.*;

public class Solution {
    public String convert(String s, int numRows) {
        // Edge case: If zigzag not needed, return s
        if (numRows == 1 || s.length() <= numRows) return s;

        // Create a list of StringBuilder for each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());

        int currentRow = 0;        // Track current row index
        boolean goingDown = false; // Track direction

        // Iterate characters in input string
        for (char c : s.toCharArray()) {
            // Append character to current row's StringBuilder
            rows.get(currentRow).append(c);

            // If we're at the top or bottom, reverse direction
            if (currentRow == 0 || currentRow == numRows - 1)
                goingDown = !goingDown;

            // Move to next row based on direction
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);

        return result.toString();
    }
}
