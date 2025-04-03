public class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(root.val);
        } else {
            result.set(depth, Math.max(result.get(depth), root.val));
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}