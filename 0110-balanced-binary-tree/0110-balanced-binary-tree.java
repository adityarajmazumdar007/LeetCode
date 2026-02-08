
class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }
    public int recur(TreeNode root) {
        if( root == null ) return 0;
        int lh = recur(root.left);
        if( lh == -1) return -1;
        int rh = recur(root.right);
        if (rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);

    }
}