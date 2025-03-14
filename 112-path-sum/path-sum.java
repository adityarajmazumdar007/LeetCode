class Solution {
    public boolean helper(TreeNode root,int targetSum,int currSum ){
        if(root==null)return false;
        if(root.left==null && root.right==null){
            currSum+=root.val;
            if(currSum==targetSum)return true;
            return false;
        }
        if(helper(root.left,targetSum,currSum+root.val) ==true) return true;
        if(helper(root.right,targetSum,currSum+root.val)==true) return true;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int currSum=0;
        return helper(root,targetSum,currSum);
    }
}