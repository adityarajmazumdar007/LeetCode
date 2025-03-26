
class Pair {
    public final double prob;  
    public final int node;     

    public Pair(double prob, int node) {
        this.prob = prob;
        this.node = node;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
    
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            adjList.get(u).add(new Pair(prob, v));
            adjList.get(v).add(new Pair(prob, u));
        }


        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);
        maxProb[start_node] = 1.0;  

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b.prob, a.prob) 
        );
        maxHeap.add(new Pair(1.0, start_node));

        while (!maxHeap.isEmpty()) {
            Pair top = maxHeap.poll();
            double currProb = top.prob;
            int currNode = top.node;

            if (currNode == end_node) {
                return currProb;
            }

            for (int i = 0; i < adjList.get(currNode).size(); i++) {
                Pair neighbor = adjList.get(currNode).get(i); 
                double edgeProb = neighbor.prob;
                int nextNode = neighbor.node;

                if (currProb * edgeProb > maxProb[nextNode]) {
                    maxProb[nextNode] = currProb * edgeProb;
                    maxHeap.add(new Pair(maxProb[nextNode], nextNode));
                }
}
        }

        return 0.0;
    }
}
