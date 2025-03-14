class Solution {
    public static void  check(TreeNode root, int sum, int target,List<List<Integer>>  ans, List<Integer> temp){
        if(root==null)return ;
        if(root.left == null && root.right==null){
            target=target+root.val;
            if(sum==target){
                temp.add(root.val);
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
        }
        temp.add(root.val);
        check(root.left,sum,target+root.val,ans,temp);
        check(root.right,sum,target+root.val,ans,temp);
        temp.remove(temp.size()-1);
        return ;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        check(root,targetSum,0,ans,temp);
        return ans;
    }
}