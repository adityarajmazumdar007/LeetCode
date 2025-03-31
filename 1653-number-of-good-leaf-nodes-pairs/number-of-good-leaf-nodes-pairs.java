class Solution {
    public int countPairs(TreeNode root, int distance) {
        // Step 1: Build Parent Mapping & Collect Leaf Nodes
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<TreeNode> leafNodes = new ArrayList<>();
        findMapping(root, parentMap, leafNodes);
        
        int count = 0;

        // Step 2: BFS from each leaf node
        for (int i = 0; i < leafNodes.size(); i++) {
            count += bfs(leafNodes.get(i), parentMap, leafNodes, distance);
        }

        return count / 2; // Each pair is counted twice, so divide by 2
    }

    private void findMapping(TreeNode root, HashMap<TreeNode, TreeNode> parentMap, List<TreeNode> leafNodes) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                leafNodes.add(node); // Store leaf nodes
            }
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    private int bfs(TreeNode startLeaf, HashMap<TreeNode, TreeNode> parentMap, List<TreeNode> leafNodes, int distance) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(startLeaf);
        visited.add(startLeaf);
        
        int level = 0, count = 0;

        while (!queue.isEmpty() && level <= distance) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (level > 0 && leafNodes.contains(node)) {
                    count++; // Found a good leaf pair
                }
                
                // Expand search in three directions (left, right, parent)
                if (node.left != null && visited.add(node.left)) queue.offer(node.left);
                if (node.right != null && visited.add(node.right)) queue.offer(node.right);
                if (parentMap.containsKey(node) && visited.add(parentMap.get(node))) {
                    queue.offer(parentMap.get(node));
                }
            }
            level++;
        }
        
        return count;
    }
}
