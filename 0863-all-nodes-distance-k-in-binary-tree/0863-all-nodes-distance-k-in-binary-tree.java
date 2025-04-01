class Solution {
    public void findMapping(TreeNode root, HashMap<TreeNode, TreeNode> childToParentMapping) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (!bfs.isEmpty()) {
            TreeNode parent = bfs.poll();
            if (parent.left != null) {
                bfs.offer(parent.left);
                childToParentMapping.put(parent.left, parent);
            }
            if (parent.right != null) {
                bfs.offer(parent.right);
                childToParentMapping.put(parent.right, parent);
            }
        }
    }

    Queue<TreeNode> findKTreeNodes(TreeNode target, int k, HashMap<TreeNode, TreeNode> childToParentMapping) {
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        visited.add(target);
        int counter = 0;
        q.offer(target);
        while (!q.isEmpty()) {
            if (counter++ == k) break;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode front = q.poll();
                if (front.left != null && !visited.contains(front.left)) {
                    visited.add(front.left);
                    q.offer(front.left);
                }
                if (front.right != null && !visited.contains(front.right)) {
                    visited.add(front.right);
                    q.offer(front.right);
                }
                if (childToParentMapping.containsKey(front) && !visited.contains(childToParentMapping.get(front))) {
                    visited.add(childToParentMapping.get(front));
                    q.offer(childToParentMapping.get(front));
                }
            }
        }
        return q;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> childToParentMapping = new HashMap<>();
        findMapping(root, childToParentMapping);
        Queue<TreeNode> q = findKTreeNodes(target, k, childToParentMapping);
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}
