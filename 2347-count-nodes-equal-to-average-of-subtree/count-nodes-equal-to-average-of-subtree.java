class Solution {
    private int count1 = 0;

    public int averageOfSubtree(TreeNode root) {
        count(root);
        return count1;
    }

    private int[] count(TreeNode node) {
        if (node == null) {
            return new int[]{0,0};
        }

        int left[] = count(node.left);
        int right[] = count(node.right);

        int sum = left[0] + right[0] + node.val;

        int nodeCount = left[1] + right[1] + 1;

        if(node.val == sum/nodeCount) {
             count1++; 
        }
        return new int[] {sum, nodeCount};
    }
}