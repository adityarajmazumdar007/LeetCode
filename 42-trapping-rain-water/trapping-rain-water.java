class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lMax = 0;
        int rMax = 0;
        int i = 0;
        int j = n-1;
        int ans = 0;
        while(i < j) {
            if (height[i]<= height[j]) {
            lMax = Math.max(height[i],lMax);
            ans+=lMax - height[i];
            i++;
        } else {
            rMax = Math.max(height[j],rMax);
            ans+=rMax - height[j];
            j--;
        }
        }
        return ans;
    }
}