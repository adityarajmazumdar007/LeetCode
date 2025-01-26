
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            mp1.put(s1.charAt(i), mp1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;

        while (j < s2.length()) {
            mp2.put(s2.charAt(j), mp2.getOrDefault(s2.charAt(j), 0) + 1);
            if (j - i + 1 == s1.length()) {
                if (mp1.equals(mp2)) return true;
                char startChar = s2.charAt(i);
                mp2.put(startChar, mp2.get(startChar) - 1);
                if (mp2.get(startChar) == 0) mp2.remove(startChar);
                i++;
                
            }
            j++;
        }

        return false;
    }
}