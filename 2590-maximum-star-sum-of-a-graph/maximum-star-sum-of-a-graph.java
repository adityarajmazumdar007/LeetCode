class Solution {
   public static int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            graph.get(nodeA).add(vals[nodeB]); 
            graph.get(nodeB).add(vals[nodeA]); 
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = graph.get(i);
            Collections.sort(neighbors, Collections.reverseOrder());
            
            int currentSum = vals[i];
            int count = 0; 
            
            for (int neighborVal : neighbors) {
                if (count < k && neighborVal > 0) { 
                    currentSum += neighborVal;
                    count++;
                } else {
                    break;
                }
            }
            
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}