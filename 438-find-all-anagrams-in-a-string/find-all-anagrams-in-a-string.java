
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();
        
        for (char ch : p.toCharArray()) {
            mp1.put(ch, mp1.getOrDefault(ch, 0) + 1);
        }
        
        int i = 0, j = 0;
        while (j < s.length()) {
            mp2.put(s.charAt(j), mp2.getOrDefault(s.charAt(j), 0) + 1);
            if (j - i + 1 == p.length()) {
                if (mp1.equals(mp2)) {
                    ans.add(i);
                }
                mp2.put(s.charAt(i), mp2.get(s.charAt(i)) - 1);
                if (mp2.get(s.charAt(i)) == 0) {
                    mp2.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}