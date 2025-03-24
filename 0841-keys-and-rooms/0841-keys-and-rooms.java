class Solution {
   private static void dfs(List<List<Integer>> rooms,Integer src,int vis []){
       vis[src]=1;
       for(Integer x:rooms.get(src) ){
           if(vis[x]==-1){
               dfs(rooms,x,vis);
           }
       }
   }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int vis [] = new int[rooms.size()];
        Arrays.fill(vis,-1);
        dfs(rooms,0,vis);
        for(int x:vis){
            if(x==-1)return false;
        }
        return true;
    }
}