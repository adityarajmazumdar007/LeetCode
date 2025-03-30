class Solution {
    int[] parent;
    int components;

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // Path compression
    }

    private boolean union(int par, int child) {
        int childParent = find(child);

        // If the child already has a parent, return false
        if (childParent != child) {
            return false;
        }

        int parentParent = find(par);

        // If parent and child already connected (cycle detected), return false
        if (parentParent == childParent) {
            return false;
        }

        // Assign parent and decrease components
        parent[child] = parentParent;
        components--;
        return true;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        components = n;
        parent = new int[n];
        
        // Initialize each node as its own parent (disjoint set)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Process left and right children
        for (int i = 0; i < n; i++) {
            if (leftChild[i] >= 0 && !union(i, leftChild[i])) {
                return false;
            }
            if (rightChild[i] >= 0 && !union(i, rightChild[i])) {
                return false;
            }
        }

        // A valid binary tree should have exactly one component
        return components == 1;
    }
}
