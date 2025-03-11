
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int maxD [] = new int[1];
        findHeight(root, maxD);
        return maxD[0];
    }
    public int findHeight(TreeNode root, int maxD[]) {
        if(root == null) return 0;
        int leftHeight = findHeight(root.left, maxD);
        int rightHeight = findHeight(root.right, maxD);
        maxD[0] = Math.max(maxD[0],leftHeight + rightHeight);
        return 1+ Math.max(leftHeight, rightHeight);
    }
}