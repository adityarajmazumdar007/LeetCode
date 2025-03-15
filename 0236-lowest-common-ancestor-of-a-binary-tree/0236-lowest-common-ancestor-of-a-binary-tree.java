
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftCall = lowestCommonAncestor (root.left, p, q);
        TreeNode rightCall = lowestCommonAncestor( root.right, p, q);
        if ( leftCall == null) {
            return rightCall;
        }
        if ( rightCall == null ) {
            return leftCall;
        }
        return root;
    }
}