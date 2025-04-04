class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int sum) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return sum * 10 + root.val;

        int leftSum = sumNumbers(root.left, sum * 10 + root.val);
        int rightSum = sumNumbers(root.right, sum * 10 + root.val);

        return leftSum + rightSum;
    }
}