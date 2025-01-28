class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxFreq = 0; 
        int maxi = 0;    
        while (j < s.length()) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(s.charAt(j))); 
            while (j - i + 1 - maxFreq > k) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                maxFreq = Math.max(maxFreq, mp.get(s.charAt(i))); 
                if(mp.get(s.charAt(i))==0){mp.remove(s.charAt(i));}
                i++;
            }
            maxi = Math.max(maxi, j - i + 1);
            j++;
        }
        return maxi;
    }
}