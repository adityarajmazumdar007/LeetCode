class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        int level = 0;
        char[] genes = {'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String current = queue.poll();

                if (current.equals(end)) return level;

                for (int i = 0; i < current.length(); i++) {
                    for (char ch : genes) {
                        if (current.charAt(i) == ch) continue;
                        StringBuilder mutated = new StringBuilder(current);
                        mutated.setCharAt(i, ch);
                        String neighbour = mutated.toString();

                        if (!visited.contains(neighbour) && bankSet.contains(neighbour)) {
                            visited.add(neighbour);
                            queue.offer(neighbour);
                        }
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
