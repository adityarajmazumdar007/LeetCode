import java.util.*;

// LC 1948 – Delete Duplicate Folders in System
class Solution {

    // Trie-like node for folder tree
    static class Node {
        String name;                                  // folder name ("" for root)
        Map<String, Node> children = new HashMap<>(); // subfolders by name
        String serial = "";                           // canonical signature of subtree
        boolean deleted = false;                      // whether this subtree is to be removed
        Node(String name) { this.name = name; }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // 1) Build the folder tree
        Node root = new Node(""); // virtual root
        for (List<String> p : paths) {
            Node cur = root;
            for (String part : p) {
                cur.children.putIfAbsent(part, new Node(part)); // create if absent
                cur = cur.children.get(part);
            }
        }

        // 2) Post-order DFS to compute canonical serialization and count frequencies
        Map<String, Integer> freq = new HashMap<>();
        computeSerial(root, freq);

        // 3) Mark nodes whose non-empty signature appears at least twice
        markDuplicates(root, freq);

        // 4) Collect remaining folders' paths (skip any marked subtree)
        List<List<String>> ans = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        collectRemaining(root, path, ans);

        return ans;
    }

    // Post-order: compute each node's canonical signature (children-only).
    // Leaves return "" (empty) so they won't be considered duplicates (non-empty rule).
    private String computeSerial(Node node, Map<String, Integer> freq) {
        if (node.children.isEmpty()) {
            node.serial = ""; // empty set of subfolders => empty signature
            return node.serial;
        }

        // Sort children names to get a canonical order
        List<String> names = new ArrayList<>(node.children.keySet());
        Collections.sort(names);

        // Signature = (name1#childSig1 name2#childSig2 ...)
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (String childName : names) {
            Node child = node.children.get(childName);
            String childSig = computeSerial(child, freq); // post-order
            sb.append(childName).append('#').append(childSig);
        }
        sb.append(')');

        node.serial = sb.toString();

        // Count only non-empty signatures (nodes with at least one child)
        freq.put(node.serial, freq.getOrDefault(node.serial, 0) + 1);
        return node.serial;
    }

    // Mark any node whose non-empty signature frequency >= 2
    private void markDuplicates(Node node, Map<String, Integer> freq) {
        if (!node.serial.isEmpty() && freq.getOrDefault(node.serial, 0) > 1) {
            node.deleted = true; // mark this node; its whole subtree will be skipped
        }
        for (Node child : node.children.values()) {
            markDuplicates(child, freq);
        }
    }

    // Pre-order: emit paths for nodes not marked; skip entire subtree if marked
    private void collectRemaining(Node node, Deque<String> path, List<List<String>> out) {
        // Iterate children in any order (answer can be any order)
        for (Map.Entry<String, Node> e : node.children.entrySet()) {
            Node child = e.getValue();
            if (child.deleted) continue; // skip deleted subtree entirely
            path.addLast(child.name);
            out.add(new ArrayList<>(path)); // record current folder's path
            collectRemaining(child, path, out);
            path.removeLast();
        }
    }
}
