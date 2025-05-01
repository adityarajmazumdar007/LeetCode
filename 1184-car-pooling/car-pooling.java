class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int pc[] = new int[1001];
        for(int i = 0 ; i < trips.length; i++) {
            pc[trips[i][1]] += trips[i][0];
            pc[trips[i][2]] -= trips[i][0];
        }

        int j = 0;
        for(int i = 0; i < 1001; i++) {
            j+= pc[i];
            if(j > capacity) return false;
        }

        return true;
    }
}