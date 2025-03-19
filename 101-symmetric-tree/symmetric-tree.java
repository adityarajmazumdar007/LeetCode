
class Solution {
    public boolean isSameTree(TreeNode leftSubTree, TreeNode rightSubTree) {
        if(leftSubTree == null && rightSubTree == null) return true;
        if(leftSubTree == null || rightSubTree == null) return false;
        return leftSubTree.val ==  rightSubTree.val && isSameTree(leftSubTree.left, rightSubTree.right)
        && isSameTree(leftSubTree.right, rightSubTree.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(isSameTree(root.left, root.right)) return true;
        return false;
    }
}
