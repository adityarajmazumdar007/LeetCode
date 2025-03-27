import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int n = routes.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Map each stop to the bus routes it belongs to
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedRoutes = new boolean[n];
        Set<Integer> visitedStops = new HashSet<>();

        // Start BFS from source
        for (int route : stopToRoutes.getOrDefault(source, Collections.emptyList())) {
            q.add(route);
            visitedRoutes[route] = true;
        }

        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int route = q.poll();
                
                for (int stop : routes[route]) {
                    if (stop == target) return busCount;

                    if (!visitedStops.add(stop)) continue;

                    for (int nextRoute : stopToRoutes.getOrDefault(stop, Collections.emptyList())) {
                        if (!visitedRoutes[nextRoute]) {
                            visitedRoutes[nextRoute] = true;
                            q.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }

        return -1;
    }
}
