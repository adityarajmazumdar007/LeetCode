class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        int index = 0;
        int[][] finalArray = new int[intervals.length+1][2];
        while(i < n && intervals[i][1] < newInterval[0]){
            finalArray[index++]=intervals[i++];
        }
        while(i < n && newInterval[1]>=intervals[i][0] ){
            newInterval[0]= Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]= Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        finalArray[index++]=newInterval;
        while(i < n){
            finalArray[index++]=intervals[i++];
        }
        return Arrays.copyOf(finalArray, index);
        
    }
}