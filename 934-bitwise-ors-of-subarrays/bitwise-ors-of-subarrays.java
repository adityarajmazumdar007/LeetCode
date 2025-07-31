import java.util.*;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> resultSet = new HashSet<>(); // Final unique OR values
        Set<Integer> prevSet = new HashSet<>();   // ORs ending at previous index

        for (int num : arr) {
            Set<Integer> currSet = new HashSet<>();
            currSet.add(num); // Start a new subarray from current num

            // Extend all previous ORs with current number
            for (int prev : prevSet) {
                currSet.add(prev | num);
            }

            // Add current ORs to the global result set
            resultSet.addAll(currSet);

            // Prepare for next iteration
            prevSet = currSet;
        }

        return resultSet.size();
    }
}
