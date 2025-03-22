class Solution {
    public boolean isAnagram(String s, String t) {
        int charr []= new int[26];
        if(s.length()!=t.length()) return false;
        for (int i = 0; i< s.length() ; i++) {
            charr[s.charAt(i)-'a']++;
            charr[t.charAt(i)-'a']--;
        }
        for (int i =0; i<charr.length;i++) {
            if(charr[i]!=0) return false;
        }
        return true;
    }
}