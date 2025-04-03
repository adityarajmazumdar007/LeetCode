class Solution {
    public String minRemoveToMakeValid(String s) {
    int n = s.length();
    int count = 0;
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < n; ++i) {
        if (s.charAt(i) == '(') {
            ++count;
        } else if (s.charAt(i) == ')') {
            if (count == 0) {
                sb.setCharAt(i, '#');
            } else {
                --count;
            }
        }
    }
    
    // Extra opening bracket
    count = 0;
    for (int i = n - 1; i >= 0; --i) {
        if (s.charAt(i) == ')') {
            ++count;
        } else if (s.charAt(i) == '(') {
            if (count == 0) {
                sb.setCharAt(i, '#');
            } else {
                --count;
            }
        }
    }
    
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < n; ++i) {
        if (sb.charAt(i) != '#') {
            ans.append(sb.charAt(i));
        }
    }
    
    return ans.toString();
}

}