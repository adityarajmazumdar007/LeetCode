import java.util.*;

class Solution {

    // Simple class to hold word index and current character index within that word
    private static class Node {
        int wordIndex;
        int charIndex;

        Node(int wi, int ci) {
            this.wordIndex = wi;
            this.charIndex = ci;
        }
    }

    /** Counts the number of words that are a subsequence of s. */
    public int numMatchingSubseq(String s, String[] words) {
        // Create buckets for each character 'a' through 'z'
        List<Node>[] waitingLists = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            waitingLists[i] = new ArrayList<>();
        }

        // Initialize buckets with the first character of each word
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null && !words[i].isEmpty()) {
                int bucketIndex = words[i].charAt(0) - 'a';
                waitingLists[bucketIndex].add(new Node(i, 0));
            }
        }

        int count = 0;
        // Process each character in the main string s
        for (char c : s.toCharArray()) {
            int currentBucketIndex = c - 'a';
            // Get the list of words waiting for this character
            List<Node> currentBucket = waitingLists[currentBucketIndex];
            // Clear the bucket for processing; new nodes will be added later
            waitingLists[currentBucketIndex] = new ArrayList<>();

            // Process each node that was waiting for character c
            for (Node node : currentBucket) {
                node.charIndex++; // Advance pointer within the word

                // Check if we reached the end of the word
                if (node.charIndex == words[node.wordIndex].length()) {
                    count++; // Found a matching subsequence
                } else {
                    // Move the node to the bucket for the *next* character it needs
                    int nextCharBucketIndex = words[node.wordIndex].charAt(node.charIndex) - 'a';
                    waitingLists[nextCharBucketIndex].add(node);
                }
            }
        }

        return count;
    }
}