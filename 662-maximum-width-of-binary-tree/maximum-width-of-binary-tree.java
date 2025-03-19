class Pair {
    TreeNode node;
    int currentPosition;
    Pair ( TreeNode node,  int currentPosition) {
        this.node = node;
        this.currentPosition = currentPosition;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxDistance = 0;
        Queue< Pair > q = new LinkedList<>();
        q.offer( new Pair ( root, 0));
        while ( q.size() != 0 ) {
            int sz = q.size();
            int firstVal = 0;
            int lastVal = 0;
            for ( int i = 0; i < sz; i++ ) {
                Pair parent = q.poll();
                TreeNode node = parent.node;
                int distance = parent.currentPosition;
                if(i == 0 ) {
                    firstVal = distance;
                }
                if ( i == sz-1 ) {
                    lastVal = distance;
                }
                if ( node.left != null ) {
                    q.offer( new Pair(node.left, 2*distance+1) );
                }
                if ( node.right != null ) {
                    q.offer ( new Pair (node.right, 2*distance + 2));
                }
            }
            maxDistance = Math.max (maxDistance, lastVal - firstVal + 1);
        }
        return maxDistance;
    }
}