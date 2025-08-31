class Solution {

    // Finds the in-order successor value for a node with two children:
    // i.e., the minimum value in its right subtree.
    public static int findSuccessor(TreeNode root) { 
        int mini = root.val;
        while (root.left != null) {
            mini = Math.min(root.left.val, mini);
            root = root.left;
        }
        return mini;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

       

        // Normal BST search to reach the node to delete
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // --- Found the node with value == key ---
            // child node case A
            if (root.left == null && root.right == null) {          
            return null;
        }
            // --- Case b: One child (left is null) ---
            else if (root.left == null) return root.right;

            // --- Case B: One child (right is null) ---
            else if (root.right == null) return root.left;

            // --- Case C: Two children ---
            // Replace current node's value with its in-order successor (min of right subtree)
            // and delete that successor from the right subtree.
            int v = findSuccessor(root.right);                   
            root.val = v;
            root.right = deleteNode(root.right, v);
        }
        return root;
    }
}
