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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        inorder(root, target, k, q);                 // CHANGED: build window on the fly
        return new ArrayList<>(q);
    }

    // Inorder DFS with early stop; returns true if we can prune remaining recursion.  // CHANGED
    private boolean inorder(TreeNode node, double target, int k, Deque<Integer> q) {  // CHANGED
        if (node == null) return false;

        // Left
        if (inorder(node.left, target, k, q)) return true;                            // CHANGED

        // Visit current node
        int v = node.val;
        if (q.size() < k) {
            q.addLast(v);                                                             // CHANGED
        } else {
            int far = q.peekFirst();  // current farthest among window (leftmost)     // CHANGED
            if (Math.abs(v - target) < Math.abs(far - target)) {
                q.pollFirst();                                                        // CHANGED
                q.addLast(v);                                                         // CHANGED
            } else if (v > target) {
                // As values increase, distance will only grow ⇒ prune               // CHANGED
                return true;                                                          // CHANGED
            }
            // else: v <= target and not better than 'far' → keep scanning right
        }

        // Right
        return inorder(node.right, target, k, q);                                     // CHANGED
    }
}
