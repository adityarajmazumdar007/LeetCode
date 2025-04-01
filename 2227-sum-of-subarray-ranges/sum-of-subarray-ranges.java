class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sumMax = 0, sumMin = 0;
        
        int[] nse = new int[n];  // Next smaller element index
        int[] pse = new int[n];  // Previous smaller element index
        int[] nge = new int[n];  // Next greater element index
        int[] pge = new int[n];  // Previous greater element index
        
        Stack<Integer> st = new Stack<>();
        
        // Finding Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        st.clear();
        
        // Finding Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        // Compute contribution of minimum elements
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sumMin += left * right * nums[i];
        }
        
        st.clear();
        
        // Finding Next Greater Element (NGE)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        st.clear();
        
        // Finding Previous Greater Element (PGE)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        // Compute contribution of maximum elements
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sumMax += left * right * nums[i];
        }
        
        // Return the difference
        return sumMax - sumMin;
    }
}
