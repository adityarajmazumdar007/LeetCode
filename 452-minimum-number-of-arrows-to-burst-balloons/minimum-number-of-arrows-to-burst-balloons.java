import java.util.*;

public class Solution {
    public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0) return 0;
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

    int arrows = 0;
    // Set lastArrowPos to less than all possible x_start values (i.e., less than Integer.MIN_VALUE)
    long lastArrowPos = Long.MIN_VALUE; // Use long to avoid overflow

    for (int[] balloon : points) {
        int x_start = balloon[0];
        int x_end = balloon[1];
        if (x_start > lastArrowPos) {
            arrows++;
            lastArrowPos = x_end;
        }
    }
    return arrows;
}

}
