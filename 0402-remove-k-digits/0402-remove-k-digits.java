class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < nums.length(); i++) {
            char c = nums.charAt(i);
            while (k > 0 && !st.isEmpty() && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
            if (st.size() == 1 && st.peek() == '0') {
                st.pop();
            }
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        String ans = sb.toString();
        return ans.isEmpty() ? "0" : ans;
    }
}
