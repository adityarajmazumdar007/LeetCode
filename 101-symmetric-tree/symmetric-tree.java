class Solution {
    public boolean checkHelper(TreeNode left,TreeNode right){
        if(left==null && right== null)return true;
        if(left== null || right == null ) return false;
        return (left.val == right.val &&checkHelper(left.left,right.right) &&checkHelper(left.right,right.left));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null || checkHelper(root.left,root.right)== true) return true;
        return false;
    }
}