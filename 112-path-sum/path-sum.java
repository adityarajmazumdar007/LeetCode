class Solution {
    public boolean helper(TreeNode root,int targetSum,int currSum ){
        if(root==null)return false;
        if(root.left==null && root.right==null){
            currSum+=root.val;
            if(currSum==targetSum)return true;
            return false;
        }
        currSum+=root.val;
        if(helper(root.left,targetSum,currSum)==true ||helper(root.right,targetSum,currSum)==true )return true;
        currSum-=root.val;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int currSum=0;
        return helper(root,targetSum,currSum);
    }
}