class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }
        int i=0;  
        int j=0;
        int startIndex=-1;
        int minLen=Integer.MAX_VALUE;
        int unique=mp.size();
        while(j<s.length()){
            char ch = s.charAt(j);
            //expansion phase
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0)unique--;
            }
            //shrinking phase
            while(unique==0){
                int len = j-i+1;
                if(len<minLen){
                    minLen=len;
                    startIndex=i;
                    
                }
                 ch = s.charAt(i);
                if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
                if(mp.get(ch)>0)unique++;
            }
                i++;
            }
            j++;
        }
        if(startIndex==-1)return "";
        return s.substring(startIndex,startIndex+minLen);
    }
}