class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // function IDs
        int prevTime = 0; // boundary of last accounted time

        for (String s : logs) {
            // parse "id:type:time"
            int p1 = s.indexOf(':');
            int p2 = s.lastIndexOf(':');
            int id = Integer.parseInt(s.substring(0, p1));
            String type = s.substring(p1 + 1, p2);
            int t = Integer.parseInt(s.substring(p2 + 1));

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    // charge the running function up to t-1
                    ans[stack.peek()] += t - prevTime;
                }
                stack.push(id);
                prevTime = t; // new segment starts here
            } else {
                // ending current function id at inclusive time t
                int finished = stack.pop();
                ans[finished] += (t - prevTime + 1);
                prevTime = t + 1; // next time slot after inclusive end
            }
        }
        return ans;
    }
}