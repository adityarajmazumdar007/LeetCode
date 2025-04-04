import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1; // 1 for '+', -1 for '-'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0'); // Constructing the number
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1; // Next sign is '+'
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1; // Next sign is '-'
            } else if (c == '(') {
                stack.push(result);  // Save the current result
                stack.push(sign);    // Save the current sign
                result = 0;
                number = 0;
                sign = 1; // Reset sign for new expression inside parentheses
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // Apply sign before '('
                result += stack.pop(); // Add previous result before '('
            }
        }

        result += sign * number; // Adding last processed number
        return result;
    }
}
