// TrieNode class for each prefix node
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>(); // Stores next character nodes
    int sum = 0; // Sum of all values in the subtree rooted at this node
}

public class MapSum {
    private TrieNode root; // Root of Trie
    private Map<String, Integer> keyToVal; // Stores last value for each key

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
        keyToVal = new HashMap<>();
    }

    /** Insert key-value pair, updating any existing value */
    public void insert(String key, int val) {
        int delta = val - keyToVal.getOrDefault(key, 0); // Find how much to increment/decrement
        keyToVal.put(key, val); // Update latest value for the key

        TrieNode node = root;
        for (char c : key.toCharArray()) {
            node = node.children.computeIfAbsent(c, x -> new TrieNode()); // Add child node if missing
            node.sum += delta; // Update sum along the path
        }
    }

    /** Return sum of all values with keys starting with prefix */
    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return 0; // No such prefix
            node = node.children.get(c);
        }
        return node.sum; // Return sum at the end of the prefix
    }
}


/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */