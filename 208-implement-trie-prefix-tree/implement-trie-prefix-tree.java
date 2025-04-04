class Trie {
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
           children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode crawler = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode crawler = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (crawler.children[index] == null) {
                return false;
            }
            crawler = crawler.children[index];
        }
        return crawler.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (crawler.children[index] == null) {
                return false;
            }
            crawler = crawler.children[index];
        }
        return true;
    }
}
