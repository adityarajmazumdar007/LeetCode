import java.util.Arrays;

class Solution {     
    public boolean checkIfPossible(int val, long k, int candies[]) {
        long count = 0;
        for (int i = 0; i < candies.length; i++) { 
            count += candies[i] / val;  
        }
        return count >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }

        int ans = 0;
        int start = 1, end = maxCandy;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (checkIfPossible(mid, k, candies)) {
                ans = mid;  
                start = mid + 1; 
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
