

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
        int source = times[i][0];
        int destination = times[i][1];
        int weight = times[i][2];
        adjList.get(source).add(new ArrayList<>(Arrays.asList(destination, weight)));
    }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int distance = current.distance;

            for (int i = 0; i < adjList.get(node).size(); i++ ) {
                int neighbor = adjList.get(node).get(i).get(0);
                int weight = adjList.get(node).get(i).get(1);
                int newDistance = distance + weight;
                if (newDistance < dist[neighbor]) {
                    dist[neighbor] = newDistance;
                    pq.offer(new Pair(neighbor, newDistance));
                }
            }
        }

        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }
        return maxDelay;
    }

    class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}