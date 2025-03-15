class Solution {
     public static TreeNode mapping(TreeNode root, int target,HashMap<TreeNode,TreeNode> mp){
        TreeNode t = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size()!=0){
            TreeNode front = q.poll();
            if(front.val==target)t=front;
            if(front.left!=null){
                q.offer(front.left);
                mp.put(front.left,front);
            }
             if(front.right!=null){
                q.offer(front.right);
                mp.put(front.right,front);
            }
        }
        return t;
    }
    public static int timerHelper(TreeNode root,TreeNode targetNode,HashMap<TreeNode,TreeNode> mp){
        HashSet<TreeNode> st = new HashSet<>();
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(targetNode);
        st.add(targetNode);
        int timer=-1;
        while(q.size()!=0){
            timer++;
            int sz = q.size();
            for(int i=0;i<sz;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && !st.contains(curr.left)){
                    q.offer(curr.left);
                    st.add(curr.left);
                }
                if(curr.right!=null && !st.contains(curr.right)){
                    q.offer(curr.right);
                    st.add(curr.right);
                }
                if(mp.containsKey(curr) && !st.contains(mp.get(curr))){
                    q.offer(mp.get(curr));
                    st.add(mp.get(curr));
                }
            }
        }
        return timer;
    }
    public int amountOfTime(TreeNode root, int target) {
        HashMap<TreeNode,TreeNode> mp = new HashMap<>();
        TreeNode targetNode=mapping(root,target,mp);
        return timerHelper(root,targetNode,mp);
    }
}