
class Solution {        
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> preOrder = new Stack<>();
        if (root == null) return ans;
        preOrder.push(root);
        while(preOrder.size() != 0) {
            TreeNode top = preOrder.pop();
            ans.add(top.val);
            if(top.right != null) {
                preOrder.push(top.right);
            }
            if(top.left != null) {
                preOrder.push(top.left);
            }
        }
        return ans;
    }
}