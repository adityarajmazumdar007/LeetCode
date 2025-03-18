/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> l1 = new ArrayList<>();
        if (root == null) {
            return l1; 
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l2 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                l2.add(curr.val); 
                    for (Node child : curr.children) {
                        q.offer(child);
                }
            }
            l1.add(l2); 
        }
        return l1;
    }
}