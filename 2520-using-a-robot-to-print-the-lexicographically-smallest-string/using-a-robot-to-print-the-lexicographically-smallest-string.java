import java.util.*;

public class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minChar = new char[n];
        char curMin = '{';  // char after 'z' in ASCII
        
        // Precompute min char from right to left
        for (int i = n - 1; i >= 0; i--) {
            curMin = (char)Math.min(curMin, s.charAt(i));
            minChar[i] = curMin;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < n) {
            stack.push(s.charAt(i));

            // While top of stack ≤ next min char in s, pop it to result
            while (!stack.isEmpty() && (i == n - 1 || stack.peek() <= minChar[i + 1])) {
                result.append(stack.pop());
            }

            i++;
        }

        // Pop remaining chars in stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
