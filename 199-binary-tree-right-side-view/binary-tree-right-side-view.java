
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while( q.size() != 0 ) {
            int sz = q.size();
            for(int i = 0;  i < sz; i++) {
                TreeNode front = q.poll();
                if ( i == sz-1) ans.add(front.val);
                if(front.left != null) {
                    q.offer(front.left);
                }
                if(front.right != null) {
                    q.offer(front.right);
                }
            }
        }
        return ans;
    }
}