import java.util.*;

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{0, 0});
        visited.add("0,0");

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int a = state[0];
            int b = state[1];

            if (a + b == z) return true;

            List<int[]> nextStates = new ArrayList<>();
            // Fill jug x
            nextStates.add(new int[]{x, b});
            // Fill jug y
            nextStates.add(new int[]{a, y});
            // Empty jug x
            nextStates.add(new int[]{0, b});
            // Empty jug y
            nextStates.add(new int[]{a, 0});
            // Pour x -> y
            int pourXtoY = Math.min(a, y - b);
            nextStates.add(new int[]{a - pourXtoY, b + pourXtoY});
            // Pour y -> x
            int pourYtoX = Math.min(b, x - a);
            nextStates.add(new int[]{a + pourYtoX, b - pourYtoX});

            for (int[] next : nextStates) {
                String key = next[0] + "," + next[1];
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(next);
                }
            }
        }

        return false;
    }
}
