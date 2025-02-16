class Solution {
    class Pair implements Comparable<Pair> {
        String video;
        int val;
        Pair(String video, int val) {
            this.video = video;
            this.val = val;
        }
        public int compareTo(Pair that) {
            if( this.val == that.val) {
                return this.video.compareTo(that.video);
            }
            return this.val - that.val;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.offer(id);
        seen.add(id);
        for(int i = 0; i < level; i++) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                int curr = q.poll();
                for(int friend: friends[curr]) {
                    if(!seen.contains(friend)) {
                        q.offer(friend);
                        seen.add(friend);
                    }
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for(int ID: q) {
            for(String movie: watchedVideos.get(ID)) {
                map.put(movie, map.getOrDefault(movie, 1) + 1);
            }
        }

        List<Pair> ls = new ArrayList<>();
        for(String video : map.keySet()) {
            ls.add(new Pair(video, map.get(video)));
        }
        Collections.sort(ls);
        
        List<String> result = new ArrayList<>();
        for(Pair p: ls) {
            result.add(p.video);
        }
        return result;
    }
}