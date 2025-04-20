class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                
                if (token.equals("+")) {
                    stack.push(x2 + x1);
                } else if (token.equals("-")) {
                    stack.push(x2 - x1);
                } else if (token.equals("*")) {
                    stack.push(x2 * x1);
                } else {
                    stack.push(x2 / x1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
