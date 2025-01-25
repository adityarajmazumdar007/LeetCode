class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        if(s.length()<=0)return 0;
        int start =0;
        int end =0;
        int ans= -1;
        while(end<s.length()){
            mp.put(s.charAt(end),mp.getOrDefault(s.charAt(end),0)+1);
            while(mp.size()<end-start+1){
                mp.put(s.charAt(start),mp.get(s.charAt(start))-1);
                if(mp.get(s.charAt(start))==0){mp.remove(s.charAt(start));}
                start++;
            }
            ans=Math.max(ans,end-start+1);    
            end++;
        }
        return ans;
    }
}