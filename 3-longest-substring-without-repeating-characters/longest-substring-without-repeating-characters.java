class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        if(s.length()<=0)return 0;
        int start =0;
        int end =0;
        int ans= -1;
        while(end<s.length()){
            int windowSize = end-start+1;
            char ch = s.charAt(end);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            while(mp.size()< windowSize) {
                char ch1 = s.charAt(start);
                mp.put(ch1,mp.get(ch1)-1);
                if(mp.get(ch1)==0){mp.remove(ch1);}
                start++;
                windowSize = end-start+1;
            }
            windowSize = end-start+1;
            ans=Math.max(ans,windowSize);    
            end++;
        }
        return ans;
    }
}