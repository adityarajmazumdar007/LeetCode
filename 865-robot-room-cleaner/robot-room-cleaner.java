/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
     private static final int[][] DIR = { {-1,0}, {0,1}, {1,0}, {0,-1} };
        private final Set<String> visited = new HashSet<>();

        public void cleanRoom(Robot robot) {
            dfs(robot, 0, 0, 0); // start at local (0,0), facing Up (0)
        }

        private void dfs(Robot robot, int r, int c, int d) {
            String key = r + "#" + c;
            if (visited.contains(key)) return;
            visited.add(key);
            robot.clean();

            // Try 4 directions, turning right after each try
            for (int k = 0; k < 4; k++) {
                int nd = (d + k) % 4;
                int nr = r + DIR[nd][0];
                int nc = c + DIR[nd][1];

                // Face nd (we achieve this by turning right each loop iteration)
                if (!visited.contains(nr + "#" + nc)) {
                    if (robot.move()) {
                        dfs(robot, nr, nc, nd);
                        goBack(robot); // return to (r,c) and restore facing
                    }
                }
                robot.turnRight(); // prepare to try next direction
            }
        }

        // Backtrack one step and restore facing
        private void goBack(Robot robot) {
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        
        
    }
    
}