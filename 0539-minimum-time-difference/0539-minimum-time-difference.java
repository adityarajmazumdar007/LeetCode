import java.util.*;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        // There are only 1440 unique minutes in a day
        if (timePoints.size() > 1440) return 0;

        // Step 1: Convert "HH:MM" to total minutes
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int min = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            minutes.add(min);
        }

        // Step 2: Sort the list
        Collections.sort(minutes);

        // Step 3: Find minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }

        // Step 4: Check wrap-around difference (across midnight)
        int first = minutes.get(0);
        int last = minutes.get(minutes.size() - 1);
        minDiff = Math.min(minDiff, 1440 - (last - first));

        return minDiff;
    }
}
