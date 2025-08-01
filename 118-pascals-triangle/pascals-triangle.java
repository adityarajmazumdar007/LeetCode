class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows <= 0) return triangle; // edge case

        // First row
        triangle.add(new ArrayList<>(Arrays.asList(1)));

        // Build remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();

            // First element
            row.add(1);

            // Middle elements
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element
            row.add(1);

            triangle.add(row);
        }

        return triangle;  
    }
}