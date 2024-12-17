import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            adj.get(prerequisite).add(course);
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int course : adj.get(i)) {
                indegree[course]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] topoSort = new int[numCourses];
        int ind = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topoSort[ind++] = node;

            for (int course : adj.get(node)) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    q.add(course);
                }
            }
        }
        if (ind == numCourses) {
            return topoSort;
        } else {
            return new int[0];
        }
    }
}
