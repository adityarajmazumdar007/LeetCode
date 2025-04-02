class Solution {
    public void solve(TreeNode l, TreeNode r, int level) {
        if (l == null || r == null) { // Not a leaf node
            return;
        }

        if (level % 2 == 1) { // If it's an odd level, swap values
            int temp = l.val;
            l.val = r.val;
            r.val = temp;
        }

        // Recur for children
        solve(l.left, r.right, level + 1);
        solve(l.right, r.left, level + 1);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        solve(root.left, root.right, 1); // Start from level 1
        return root;
    }
}
