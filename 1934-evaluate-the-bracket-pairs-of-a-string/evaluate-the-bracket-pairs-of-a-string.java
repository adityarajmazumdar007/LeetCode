
class Solution {
    /** Evaluates bracket pairs in a string using provided knowledge, replacing unknown keys with '?'. */
    public String evaluate(String s, List<List<String>> knowledge) {
        // 1. Initialize
        Map<String, String> knowledgeMap = new HashMap<>();
        for (List<String> entry : knowledge) {
            if (entry != null && entry.size() == 2) {
                knowledgeMap.put(entry.get(0), entry.get(1));
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        int n = s.length();

        // 2. Iterate & 3. Process Character
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                int j = i + 1; // Start searching for ')' after '('
                // Find the closing bracket
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }

                // Check if closing bracket was found before end of string
                if (j < n) { // Found ')'
                    String key = s.substring(i + 1, j);
                    String value = knowledgeMap.getOrDefault(key, "?");
                    resultBuilder.append(value);
                    i = j; // Move index past the closing bracket
                } else {
                    // Malformed: '(' without matching ')' before end?
                    // As per problem desc, assume no nested/malformed.
                    // If we had to handle it, maybe append the '(' and continue?
                    // For this problem, this case implies the rest is part of the key,
                    // but since ')' is guaranteed by problem constraints (implicitly),
                    // this 'else' might not be strictly needed if input is always valid.
                    // Let's assume valid pairs, so j will always be < n if i finds '('.
                     resultBuilder.append(currentChar); // Fallback: treat '(' as literal if no ')' found (shouldn't happen per rules)
                }
            } else {
                // Not an opening bracket, just append
                resultBuilder.append(currentChar);
            }
        }

        // 4. Return
        return resultBuilder.toString();
    }
}