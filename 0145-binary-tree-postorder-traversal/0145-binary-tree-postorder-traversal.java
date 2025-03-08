class Solution {
    public void helper ( TreeNode root, List<Integer> ans ) {
        if( root == null ) {
            return;
        }
        helper( root.left, ans );
        helper(root.right, ans);
        ans.add( root.val );
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper( root, ans);
        return ans;
    }
}