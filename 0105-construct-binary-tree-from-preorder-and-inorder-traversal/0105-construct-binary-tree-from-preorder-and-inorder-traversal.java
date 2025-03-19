class Solution {
    public static TreeNode constructTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart, int inEnd,HashMap<Integer,Integer> mp){
        if(preStart>preEnd || inStart>inEnd)return null;
        TreeNode root= new TreeNode(preorder[preStart]);
        int inRoot= mp.get(preorder[preStart]);
        int numsLeft=inRoot-inStart;
        root.left=constructTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,mp);
        root.right=constructTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,mp);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if(preorder.length !=inorder.length)return null;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return constructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mp);
    }
}