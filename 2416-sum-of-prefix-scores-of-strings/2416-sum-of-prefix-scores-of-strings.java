class Solution {

    static class TrieNode {
        TrieNode[] children;
        int countOfPrefix;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            countOfPrefix = 0;
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode crawler = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
            crawler.countOfPrefix++; // Each node keeps how many times it's been passed through
        }
        crawler.isEndOfWord = true;
    }

    // Get the sum of prefix scores for a word
    public int getPrefixScore(String word) {
        TrieNode crawler = root;
        int score = 0;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (crawler.children[index] == null) break;
            crawler = crawler.children[index];
            score += crawler.countOfPrefix;
        }
        return score;
    }

    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            insert(word); // Build the Trie
        }

        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = getPrefixScore(words[i]);
        }
        return result;
    }
}
