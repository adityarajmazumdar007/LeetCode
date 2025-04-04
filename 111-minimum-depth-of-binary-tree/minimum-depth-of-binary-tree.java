class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        if (root.left == null || root.right == null) {
            return 1 + Math.max(leftDepth, rightDepth);
        }
        
        return 1 + Math.min(leftDepth, rightDepth);
    }
}
