class Solution {
    public static TreeNode constructTree(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart, int inEnd,HashMap<Integer,Integer> mp){
        if(postStart>postEnd || inStart>inEnd)return null;
        TreeNode root= new TreeNode(postorder[postEnd]);
        int inRoot= mp.get(postorder[postEnd]);
        int numsLeft=inRoot-inStart;
        root.left=constructTree(postorder,postStart,postStart+numsLeft-1,inorder,inStart,inRoot-1,mp);
        root.right=constructTree(postorder,postStart+numsLeft,postEnd-1,inorder,inRoot+1,inEnd,mp);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length !=inorder.length)return null;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return constructTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,mp);
    }
}