class MaxStack {

    private static final class Node {
        int val;
        Node prev, next;
        Node(int v) { this.val = v; }
    }

    // DLL sentinels to avoid null checks at ends
    private final Node head; // dummy head (not a real value)
    private final Node tail; // dummy tail (not a real value)

    // Balanced BST: value -> stack (deque) of nodes with that value (in push order)
    private final TreeMap<Integer, Deque<Node>> valueBuckets;

    /** Initializes the stack object. */
    public MaxStack() {
        this.head = new Node(0);
        this.tail = new Node(0);
        // Initially link head <-> tail
        head.next = tail;
        tail.prev = head;
        this.valueBuckets = new TreeMap<>();
    }

    /** Pushes element x onto the stack. O(log n) due to TreeMap access/insert. */
    public void push(int x) {
        // Create a new node for DLL and append just before tail (stack top).
        Node node = new Node(x);
        insertBeforeTail(node);

        // Record this node in the bucket for value x (append at end to mark top-most for x).
        Deque<Node> bucket = valueBuckets.computeIfAbsent(x, k -> new ArrayDeque<>());
        bucket.addLast(node);
    }

    /** Removes the element on top of the stack and returns it. O(log n). */
    public int pop() {
        // If empty, throw an error as per typical stack contract (can be adjusted if needed).
        ///if (isEmpty()) throw new NoSuchElementException("pop() from empty stack");

        // Top node is the node just before tail.
        Node topNode = tail.prev;

        // Unlink from DLL in O(1).
        unlink(topNode);

        // Remove the corresponding node reference from its value bucket (last entry).
        int v = topNode.val;
        Deque<Node> bucket = valueBuckets.get(v);
        bucket.removeLast();                     // last is always the top-most occurrence
        if (bucket.isEmpty()) valueBuckets.remove(v);

        return v;
    }

    /** Gets the element on the top of the stack without removing it. O(1). */
    public int top() {
      //  if (isEmpty()) throw new NoSuchElementException("top() from empty stack");
        return tail.prev.val;
    }

    /** Retrieves the maximum element without removing it. O(log n). */
    public int peekMax() {
      //  if (isEmpty()) throw new NoSuchElementException("peekMax() from empty stack");
        return valueBuckets.lastKey();           // largest key in TreeMap
    }

    /**
     * Retrieves the maximum element and removes it.
     * If multiple, remove the top-most one (most recently pushed among max).
     * O(log n) due to lastKey() and map maintenance; unlink is O(1).
     */
    public int popMax() {
       // if (isEmpty()) throw new NoSuchElementException("popMax() from empty stack");

        // Find current maximum value.
        int maxVal = valueBuckets.lastKey();

        // Get the deque for maxVal and remove its top-most node (last in deque).
        Deque<Node> bucket = valueBuckets.get(maxVal);
        Node node = bucket.removeLast();         // this is the top-most max occurrence
        if (bucket.isEmpty()) valueBuckets.remove(maxVal);

        // Unlink that node from the DLL in O(1).
        unlink(node);

        return maxVal;
    }

    /* ===================== Private Helpers ===================== */

    /** Insert a node just before the tail (push to top). */
    private void insertBeforeTail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    /** Unlink a node from the DLL in O(1). */
    private void unlink(Node node) {
        Node p = node.prev, n = node.next;
        p.next = n;
        n.prev = p;
        node.prev = node.next = null; // help GC
    }

    /** Returns true if stack is empty. */
    private boolean isEmpty() {
        return head.next == tail;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */