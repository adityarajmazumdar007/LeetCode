class Solution {
    String result = "";

    public void solve(TreeNode root, StringBuilder curr) {
        if (root == null) {
            return;
        }

        // Prepend the current character (equivalent to root-to-leaf order)
        curr.insert(0, (char) (root.val + 'a'));

        // If it's a leaf node, check if it's the lexicographically smallest string
        if (root.left == null && root.right == null) {
            String str = curr.toString();
            if (result.isEmpty() || result.compareTo(str) > 0) {
                result = str;
            }
        } else {
            solve(root.left, curr);
            solve(root.right, curr);
        }

        // **Backtrack: Remove the first character to restore state**
        curr.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root) {
        solve(root, new StringBuilder());
        return result;
    }
}
