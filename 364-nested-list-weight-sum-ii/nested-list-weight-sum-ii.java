/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) return 0;

        int unweighted = 0; // sum of all integers seen up to current level
        int weighted = 0;   // final weighted sum

        List<NestedInteger> curr = nestedList; // current level
        while (!curr.isEmpty()) {
            int levelSum = 0;
            List<NestedInteger> next = new ArrayList<>();

            // Process all items at the current level
            for (NestedInteger ni : curr) {
                if (ni.isInteger()) {
                    levelSum += ni.getInteger();
                } else {
                    // collect children for the next level
                    next.addAll(ni.getList());
                }
            }

            // Update running sums:
            // - unweighted holds sum of all integers encountered so far
            // - weighted accumulates unweighted every level (inverse depth weighting)
            unweighted += levelSum;
            weighted += unweighted;

            // Move down one level
            curr = next;
        }
        return weighted;
    }
}