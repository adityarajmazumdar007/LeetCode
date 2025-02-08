class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int pre [] = new int[n];
        int suff [] = new int[n];
        int lMax = 0;
        int rMax = 0;
        for(int i = 0;i < n; i++) {
            lMax = Math.max(height[i],lMax);
            pre[i] = lMax;
        }
        for(int i = n-1;i >= 0; i--) {
            rMax = Math.max(height[i],rMax);
            suff[i] = rMax;
        }

        int ans = 0;
        for(int i = 0; i< n ; i++) {
            ans += Math.min(pre[i],suff[i]) - height[i];
        }
        return ans;
    }
}