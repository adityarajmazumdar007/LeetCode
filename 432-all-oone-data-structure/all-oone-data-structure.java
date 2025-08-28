public class AllOne {

    /** Doubly-linked list node representing one count value and its keys. */
    private static class Bucket {
        int count;                            // this bucket's count value
        LinkedHashSet<String> keys;           // keys with this exact count
        Bucket prev, next;                    // doubly linked pointers

        Bucket(int c) {
            this.count = c;
            this.keys = new LinkedHashSet<>();
        }
    }

    // Sentinels to avoid null checks: head <-> ...buckets... <-> tail
    private final Bucket head = new Bucket(0); // dummy; real counts are >=1
    private final Bucket tail = new Bucket(0); // dummy
    // Map from key to the bucket storing that key
    private final Map<String, Bucket> keyToBucket = new HashMap<>();

    /** Constructor initializes empty structure. */
    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }

    /** Increment key's count by 1; insert with 1 if new. O(1). */
    public void inc(String key) {
        if (!keyToBucket.containsKey(key)) {
            // New key: should go to count=1 bucket (right after head).
            Bucket b1 = (head.next != tail && head.next.count == 1)
                    ? head.next
                    : insertAfter(head, 1);
            b1.keys.add(key);
            keyToBucket.put(key, b1);
            return;
        }
        // Existing key: move from current bucket to next count bucket.
        Bucket cur = keyToBucket.get(key);
        int target = cur.count + 1;
        Bucket nxt = cur.next;
        Bucket dest = (nxt != tail && nxt.count == target) ? nxt : insertAfter(cur, target);

        // Move key
        cur.keys.remove(key);
        dest.keys.add(key);
        keyToBucket.put(key, dest);

        // Remove empty bucket
        if (cur.keys.isEmpty()) remove(cur);
    }

    /** Decrement key's count by 1; remove key if new count is 0. O(1). */
    public void dec(String key) {
        Bucket cur = keyToBucket.get(key); // guaranteed to exist per constraints
        int newCount = cur.count - 1;

        if (newCount == 0) {
            // Removing the key from structure
            cur.keys.remove(key);
            keyToBucket.remove(key);
            if (cur.keys.isEmpty()) remove(cur);
            return;
        }

        // Move to previous count bucket
        Bucket prv = cur.prev;
        Bucket dest = (prv != head && prv.count == newCount) ? prv : insertAfter(prv, newCount);

        cur.keys.remove(key);
        dest.keys.add(key);
        keyToBucket.put(key, dest);

        if (cur.keys.isEmpty()) remove(cur);
    }

    /** Return any key with maximal count; "" if empty. O(1). */
    public String getMaxKey() {
        if (tail.prev == head) return "";
        // return any element from the set
        return tail.prev.keys.iterator().next();
    }

    /** Return any key with minimal count; "" if empty. O(1). */
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }

    /* ----------------- Doubly-linked list helpers ----------------- */

    /** Insert a new bucket with given count right after node 'at'. */
    private Bucket insertAfter(Bucket at, int count) {
        Bucket b = new Bucket(count);
        b.prev = at;
        b.next = at.next;
        at.next.prev = b;
        at.next = b;
        return b;
    }

    /** Remove bucket 'b' from the list (only when its keys set is empty). */
    private void remove(Bucket b) {
        b.prev.next = b.next;
        b.next.prev = b.prev;
        // help GC
        b.prev = b.next = null;
    }
}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */