class Solution {
    String result = "";

    public void solve(TreeNode root, String curr) {
        if (root == null) {
            return;
        }

        // Prepend the current character to maintain the path from leaf to root
        curr = (char) (root.val + 'a') + curr;

        // If it's a leaf node, check if it's the lexicographically smallest string
        if (root.left == null && root.right == null) {
            if (result.isEmpty() || result.compareTo(curr) > 0) {
                result = curr;
            }
            return;
        }

        solve(root.left, curr);
        solve(root.right, curr);
    }

    public String smallestFromLeaf(TreeNode root) {
        solve(root, "");
        return result;
    }
}
