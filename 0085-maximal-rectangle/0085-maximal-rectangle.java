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
        int maxArea= 0;
        for(int i=0;i<n;i++){
            int area = (nse[i]-pse[i]-1) * heights[i];
            maxArea= Math.max(maxArea,area);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] intMatrix = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            intMatrix[i][j] = matrix[i][j] - '0'; 
        }
    }

        int maxArea=largestRectangleArea(intMatrix[0]);
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(intMatrix[i][j]!=0)intMatrix[i][j]+=intMatrix[i-1][j];
                else{intMatrix[i][j]=0;}
            }
           maxArea = Math.max(maxArea, largestRectangleArea(intMatrix[i]));
        }
        return maxArea;
    }
}