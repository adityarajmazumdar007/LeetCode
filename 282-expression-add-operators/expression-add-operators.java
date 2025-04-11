import java.util.*;

public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        helper(num, target, 0, "", 0, 0);
        return ans;
    }

    private void helper(String num, int target, int i, String path, long eval, long residual) {
        if (i == num.length()) {
            if (eval == target) {
                ans.add(path);
            }
            return;
        }

        String currStr = "";
        long currNum = 0;

        for (int j = i; j < num.length(); j++) {
            // Avoid numbers with leading 0
            if (j > i && num.charAt(i) == '0') return;

            currStr += num.charAt(j);
            currNum = currNum * 10 + (num.charAt(j) - '0');

            if (i == 0) {
                // First number, no operator
                helper(num, target, j + 1, currStr, currNum, currNum);
            } else {
                // '+'
                helper(num, target, j + 1, path + "+" + currStr, eval + currNum, currNum);
                // '-'
                helper(num, target, j + 1, path + "-" + currStr, eval - currNum, -currNum);
                // '*', handle precedence
                helper(num, target, j + 1, path + "*" + currStr,
                       eval - residual + residual * currNum,
                       residual * currNum);
            }
        }
    }
}
