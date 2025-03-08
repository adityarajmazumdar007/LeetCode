
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue< TreeNode > q = new LinkedList<>();
        q.offer( root );
        while( q.size()!=0 ) {
            int sz = q.size();
            List< Integer> ls = new ArrayList<>();
            for ( int i =0 ; i< sz ; i++) {
                TreeNode parent = q.poll();
                ls.add( parent.val  );
                if ( parent.left != null ) {
                    q.offer( parent.left );
                }
                if( parent.right != null) {
                    q.offer( parent.right );
                }
            }
            ans.add(new ArrayList<>(ls));
        }
        return ans;
    }
}