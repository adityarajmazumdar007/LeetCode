class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        int pse[]= new int[n];
        Stack<Integer>st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()!=0 && heights[st.peek()]>=heights[i])st.pop();
            if(st.size()==0)nse[i]=n;
            else{nse[i]=st.peek();}
            st.push(i);
        }
        Stack<Integer>st1 = new Stack<>();
        for(int i=0;i<n;i++){
            while(st1.size()!=0 && heights[st1.peek()]>=heights[i])st1.pop();
            if(st1.size()==0)pse[i]=-1;
            else{pse[i]=st1.peek();}
            st1.push(i);
        }
        int maxArea= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int area = (nse[i]-pse[i]-1) * heights[i];
            maxArea= Math.max(maxArea,area);
        }
        return maxArea;
    }
}