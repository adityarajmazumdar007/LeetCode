class Solution {
    public boolean checkHelper(TreeNode left,TreeNode right){
        if(left==null && right== null)return true;
        if(left== null || right == null ) return false;
        if(left.val != right.val)return false;
        return (checkHelper(left.left,right.right) &&checkHelper(left.right,right.left));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null || checkHelper(root.left,root.right)== true) return true;
        return false;
    }
}