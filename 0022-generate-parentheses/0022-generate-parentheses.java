class Solution {
     public void recc(int openCount, int closeCount, List<String> result, String current, int n) {
        if (openCount == n && closeCount == n) {
            result.add(current);
            return;
        }
        if (openCount < n) {
            recc(openCount + 1, closeCount, result, current + "(", n);
        }
        if (closeCount < openCount) {
            recc(openCount, closeCount + 1, result, current + ")", n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recc(0, 0, result, "", n);
        return result;
    }
}