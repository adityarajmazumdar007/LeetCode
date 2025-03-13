
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int lh= leftHeight(root.left);
        int rh=rightHeight(root.right);
        if ( lh==rh)return (int)Math.pow(2,lh)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    int leftHeight( TreeNode root){
        int h=1;
        while(root!=null){
            h++;
            root=root.left;
        }
        return h;
    }
    int rightHeight( TreeNode root){
        int h=1;
        while(root!=null){
            h++;
            root=root.right;
        }
        return h;
    }
}