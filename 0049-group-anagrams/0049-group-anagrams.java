class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (!mp.containsKey(sortedStr)) {
                mp.put(sortedStr, new ArrayList<>());
            }
            mp.get(sortedStr).add(str);
        }

        for (List<String> group : mp.values()) {
            ans.add(group);
        }

        return ans;   
    }
}