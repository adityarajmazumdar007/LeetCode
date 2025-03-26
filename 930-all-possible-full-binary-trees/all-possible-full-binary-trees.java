import java.util.*;

class Solution {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    private List<TreeNode> solve(int n) {
        if (n % 2 == 0) return new ArrayList<>(); // Even nodes can't form a Full Binary Tree
        if (n == 1) return Arrays.asList(new TreeNode(0)); // Base case

        if (memo.containsKey(n)) return memo.get(n);

        List<TreeNode> result = new ArrayList<>();

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftFBT = allPossibleFBT(i);
            List<TreeNode> rightFBT = allPossibleFBT(n - i - 1);

            for (TreeNode left : leftFBT) {
                for (TreeNode right : rightFBT) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        memo.put(n, result);
        return result;
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n);
    }
}
