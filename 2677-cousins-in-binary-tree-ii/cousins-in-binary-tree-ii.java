class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> levelSum = new ArrayList<>();

        // Step-1: Find the sum of each level and store it in the levelSum list
        while (!queue.isEmpty()) {
            int currLevelSum = 0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                currLevelSum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            levelSum.add(currLevelSum);
        }

        // Step-2: Update each node value with the cousin sum
        queue.add(root);
        root.val = 0;  // root has no cousins
        int level = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();

                // levelSum of currentLevel - siblingSum
                int siblingSum = (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);

                if (curr.left != null) {
                    curr.left.val = levelSum.get(level) - siblingSum;
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = levelSum.get(level) - siblingSum;
                    queue.add(curr.right);
                }
            }
            level++;
        }

        return root;
    }
}