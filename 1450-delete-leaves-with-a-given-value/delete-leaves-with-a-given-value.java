class Solution {
    public static  TreeNode solve(TreeNode root, int target){
        if(root==null)return null;
        root.left=solve(root.left,target);
        root.right=solve(root.right,target);
        if( root.left==null &&  root.right==null && root.val==target){return null;}
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return solve(root,target);
    }
}