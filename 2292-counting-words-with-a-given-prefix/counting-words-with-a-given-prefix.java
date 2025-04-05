class Solution {

    static class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        int countOfPrefix;

        TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
            countOfPrefix = 0;
        }
    }

    TrieNode root;

    Solution() {
        root = new TrieNode();
    }

    public void insertWords(String[] words) {
        for (String s : words) {
            TrieNode crawler = root;
            for (int j = 0; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';

                if (crawler.children[idx] == null) {
                    crawler.children[idx] = new TrieNode();
                }

                crawler = crawler.children[idx];
                crawler.countOfPrefix++;  // Increment prefix count for this node
            }
            crawler.endOfWord = true;
        }
    }

    public int prefixCount(String[] words, String pref) {
        insertWords(words);

        TrieNode crawler = root;
        for (int i = 0; i < pref.length(); i++) {
            int idx = pref.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return 0;
            }
            crawler = crawler.children[idx];
        }
        return crawler.countOfPrefix;
    }
}
