class RandomizedCollection {

    // ---- Main data structures ----
    private final List<Integer> list;                     // all elements (duplicates stored multiple times)
    private final Map<Integer, Set<Integer>> idx;         // value -> set of indices where it appears
    private final Random rand;                            // random picker over indices

    /** Initializes the empty collection. */
    public RandomizedCollection() {
        this.list = new ArrayList<>();
        this.idx  = new HashMap<>();
        this.rand = new Random(42); // seeded for reproducible demo; remove/replace seed in production
    }

    /**
     * Inserts val (even if already present).
     * @return true if the item was not present before (first occurrence), false otherwise.
     */
    public boolean insert(int val) {
        // Get or create the index set for this value.
        Set<Integer> set = idx.computeIfAbsent(val, k -> new HashSet<>());
        // Append to the end of list; its index is list.size() before adding.
        int insertIndex = list.size();
        list.add(val);
        // Track the new index in the set for val.
        set.add(insertIndex);
        // Return true iff this was the first occurrence.
        return set.size() == 1;
    }

    /**
     * Removes ONE occurrence of val if present.
     * @return true if an occurrence was removed; false if val was absent.
     */
    public boolean remove(int val) {
        Set<Integer> set = idx.get(val);
        if (set == null || set.isEmpty()) {
            return false; // val not present
        }

        // Grab an arbitrary index i where val is stored.
        int removeIndex = set.iterator().next();

        // Identify the last element in the list.
        int lastIndex = list.size() - 1;
        int lastVal   = list.get(lastIndex);

        // Move lastVal to the removeIndex position to keep array compact.
        list.set(removeIndex, lastVal);

        // Update index sets:
        // 1) Remove the occurrence at removeIndex for val.
        set.remove(removeIndex);

        // 2) If we actually moved the last element to a new spot (i != lastIndex),
        //    fix lastVal's index set: remove old lastIndex, add removeIndex.
        if (removeIndex != lastIndex) {
            Set<Integer> lastSet = idx.get(lastVal);
            // It's possible lastVal == val; sets handle this correctly.
            lastSet.remove(lastIndex);
            lastSet.add(removeIndex);
        }

        // Physically remove the last element from the list.
        list.remove(lastIndex);

        // Optional: tidy up empty sets to save memory.
        if (set.isEmpty()) {
            idx.remove(val);
        }

        return true;
    }

    /**
     * Returns a random element from the collection.
     * Each occurrence in "list" is equally likely, so duplicates have proportional probability.
     */
    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */