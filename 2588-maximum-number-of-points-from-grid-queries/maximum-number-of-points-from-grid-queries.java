class Solution {
   int[][] DIRS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

public int[] maxPoints(int[][] g, int[] queries) {
    var M = g.length;
    var N = g[0].length;
    var queryToCount = new TreeMap<Integer, Integer>();
    for (var q : queries) {
        queryToCount.put(q, 0);
    }

    var visited = new boolean[M][N];
    visited[0][0] = true;
    var nextBfs = new ArrayList<int[]>(List.of(new int[] { 0, 0 }));

    var pre = 0;
    for (var query : queryToCount.keySet()) {
        if (g[0][0] >= query) {
            queryToCount.put(query, 0);
            continue;
        }
        // BFS
        var points = new ArrayList<int[]>(nextBfs);
        nextBfs = new ArrayList<>();
        int count = 0;
        while (points.size() > 0) {
            var nextPoints = new ArrayList<int[]>();
            for (var u : points) {
                if (g[u[0]][u[1]] >= query) {
                    nextBfs.add(u);
                    continue;
                }
                count++;
                for (var d : DIRS) {
                    int nr = u[0] + d[0];
                    int nc = u[1] + d[1];
                    if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        if (g[nr][nc] < query) {
                            nextPoints.add(new int[] { nr, nc });
                        } else {
                            nextBfs.add(new int[] { nr, nc });
                        }
                    }
                }
            }
            points = nextPoints;
        }
        queryToCount.put(query, count + pre);
        pre += count;
    }

    var res = new int[queries.length];
    for (int i = 0; i < res.length; i++) {
        res[i] = queryToCount.get(queries[i]);
    }
    return res;
}
}