/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfsHeight(root, res);
        return res;
    }
      private static int dfsHeight(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1; // so a leaf gets 0

        int lh = dfsHeight(node.left, res);
        int rh = dfsHeight(node.right, res);
        int h = 1 + Math.max(lh, rh);

        // Ensure list exists for this height
        if (res.size() == h) {
            res.add(new ArrayList<>());
        }
        res.get(h).add(node.val);
        return h;
        // Note: we're NOT actually removing nodes; grouping by height simulates removal rounds.
    }
}